package br.com.safeline.modules.report.service;

import br.com.safeline.modules.report.dto.ReportRequestDTO;
import br.com.safeline.modules.report.dto.ReportResponseDTO;
import br.com.safeline.modules.report.dto.ReportResponseDTOphone;
import br.com.safeline.modules.report.model.Report;
import br.com.safeline.modules.report.repository.ReportRepository;
import br.com.safeline.modules.response.BaseResponse;
import br.com.safeline.modules.user.model.User;
import br.com.safeline.modules.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportServiceTest {

    @Mock
    private ReportRepository reportRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ReportService reportService;

    private UUID userId;

    @BeforeEach
    void setUp() {
        userId = UUID.randomUUID();
    }

    @Test
    void createdReport_success() {
        var phone = "123456789";
        var callDate = LocalDateTime.now();
        var company = "Empresa X";
        var description = "Descrição";

        var user = User.builder()
                .idUser(userId)
                .name("Nome")
                .email("email@example.com")
                .password("senha1234")
                .build();

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        when(reportRepository.save(any(Report.class))).thenAnswer(invocation -> invocation.getArgument(0));

        var request = new ReportRequestDTO(phone, callDate, company, description, userId);

        BaseResponse<ReportResponseDTO> response = reportService.createdReport(request);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals("Denúncia feita com sucesso!", response.getMessage());
        assertNotNull(response.getData());
        assertEquals(phone, response.getData().phone());
    }

    @Test
    void getAllReport_returnsList() {
        var phone = "999888777";
        var callDate = LocalDateTime.now();
        var company = "Comp";
        var description = "Desc";

        Report r = Report.builder()
                .phone(phone)
                .callDate(callDate)
                .company(company)
                .description(description)
                .status(true)
                .build();

        when(reportRepository.findAll()).thenReturn(List.of(r));

        BaseResponse<List<ReportResponseDTO>> resp = reportService.getAllReport();

        assertNotNull(resp);
        assertTrue(resp.isSuccess());
        assertNotNull(resp.getData());
        assertEquals(1, resp.getData().size());
        assertEquals(phone, resp.getData().get(0).phone());
    }

    @Test
    void getReportByPhone_noResults_returnsNoContent() {
        String phone = "000000";

        when(reportRepository.findAllByPhone(phone)).thenReturn(Collections.emptyList());

        BaseResponse<List<ReportResponseDTOphone>> resp = reportService.getReportByPhone(phone);

        assertNotNull(resp);
        assertTrue(resp.isSuccess());
        assertNull(resp.getData());
    }

}
