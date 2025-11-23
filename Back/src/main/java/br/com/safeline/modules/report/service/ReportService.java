package br.com.safeline.modules.report.service;

import br.com.safeline.modules.report.dto.ReportRequestDTO;
import br.com.safeline.modules.report.dto.ReportResponseDTO;
import br.com.safeline.modules.report.dto.ReportResponseDTOphone;
import br.com.safeline.modules.report.model.Report;
import br.com.safeline.modules.report.repository.ReportRepository;
import br.com.safeline.modules.response.BaseResponse;
import br.com.safeline.modules.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;
    private final UserRepository userRepository;

    // método para criar reports
    public BaseResponse<ReportResponseDTO> createdReport(ReportRequestDTO reportRequestDTO) {

        var user = userRepository.findById(reportRequestDTO.userId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));

        var reportSaved = reportRepository.save(
                Report.builder()
                        .user(user)
                        .phone(reportRequestDTO.phone())
                        .callDate(reportRequestDTO.callDate())
                        .company(reportRequestDTO.company())
                        .description(reportRequestDTO.description())
                        .status(true)
                        .build()
        );

        return BaseResponse.success(
                "Denúncia feita com sucesso!",
                ReportResponseDTO.builder()
                        .phone(reportSaved.getPhone())
                        .callDate(reportSaved.getCallDate())
                        .company(reportSaved.getCompany())
                        .description(reportSaved.getDescription())
                        .status(reportSaved.getStatus())
                        .build(),
                HttpStatus.CREATED.value()
        );
    }

    public BaseResponse<List<ReportResponseDTO>> getAllReport() {

        var reports = reportRepository.findAll().stream()
                .map(report -> ReportResponseDTO.builder()
                        .phone(report.getPhone())
                        .callDate(report.getCallDate())
                        .company(report.getCompany())
                        .description(report.getDescription())
                        .status(report.getStatus())
                        .build()
                )
                .collect(Collectors.toList());

        return BaseResponse.success(
                "Denúncias encontradas com sucesso!",
                reports,
                HttpStatus.OK.value()
        );
    }


    public BaseResponse<List<ReportResponseDTOphone>> getReportByPhone(String phone) {

        var reports = reportRepository.findAllByPhone(phone);

        if (reports == null || reports.isEmpty()) {
            return BaseResponse.success(
                    "Nenhuma denúncia encontrada para o número de telefone fornecido.",
                    null,
                    HttpStatus.NO_CONTENT.value()
            );
        }

        // Converte entidades para DTOs
        List<ReportResponseDTOphone> reportResponseList = reports.stream()
                .map(report -> ReportResponseDTOphone.builder()
                        .phone(report.getPhone())
                        .callDate(report.getCallDate())
                        .company(report.getCompany())
                        .description(report.getDescription())
                        .build()
                )
                .toList();

        return BaseResponse.success(
                "Denúncias encontradas com sucesso!",
                reportResponseList,
                HttpStatus.OK.value()
        );
    }

}