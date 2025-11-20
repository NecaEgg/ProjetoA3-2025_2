package br.com.safe_line.safeline.modules.report.controller;

import br.com.safe_line.safeline.modules.report.dto.ReportRequestDTO;
import br.com.safe_line.safeline.modules.report.dto.ReportResponseDTO;
import br.com.safe_line.safeline.modules.report.service.ReportService;
import br.com.safe_line.safeline.modules.response.BaseResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReportControllerTest {

    @Mock
    private ReportService reportService;

    @InjectMocks
    private ReportController reportController;

    @Test
    void getReportController_returnsServiceData() {
        when(reportService.getAllReport()).thenReturn(BaseResponse.success("ok", List.of(ReportResponseDTO.builder().phone("1").build()), 200));

        ResponseEntity<BaseResponse<List<ReportResponseDTO>>> resp = reportController.getReportController();

        assertEquals(org.springframework.http.HttpStatus.OK, resp.getStatusCode());
        assertNotNull(resp.getBody());
    }

    @Test
    void createReportController_callsService() {
        var req = new ReportRequestDTO("1", null, "c", "d", null);
        when(reportService.createdReport(req)).thenReturn(BaseResponse.success("ok", ReportResponseDTO.builder().phone("1").build(), 201));

        ResponseEntity<BaseResponse<ReportResponseDTO>> resp = reportController.createReportController(req);

        assertEquals(org.springframework.http.HttpStatus.CREATED, resp.getStatusCode());
        assertNotNull(resp.getBody());
    }

}
