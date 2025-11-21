package br.com.safeline.modules.report.controller;


import br.com.safeline.modules.report.service.ReportService;
import br.com.safeline.modules.response.BaseResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.safeline.modules.report.dto.ReportRequestDTO;
import br.com.safeline.modules.report.dto.ReportResponseDTO;
import br.com.safeline.modules.report.dto.ReportResponseDTOphone;

import java.util.List;

@RestController
@RequestMapping("/api/v1/report")
@AllArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/create")
    public ResponseEntity<BaseResponse<ReportResponseDTO>> createReportController(@RequestBody ReportRequestDTO reportRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.reportService.createdReport(reportRequestDTO));
    }

    @GetMapping("/allreport")
    public ResponseEntity<BaseResponse<List<ReportResponseDTO>>> getReportController() {
        return ResponseEntity.status(HttpStatus.OK).body(this.reportService.getAllReport());
    }

    @GetMapping("/phone")
    public ResponseEntity<BaseResponse<List<ReportResponseDTOphone>>> getReportPhoneController(@Param("phone") String phone) {
        return ResponseEntity.status(HttpStatus.OK).body(this.reportService.getReportByPhone(phone));
    }

}