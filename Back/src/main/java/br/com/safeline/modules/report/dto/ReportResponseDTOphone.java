package br.com.safeline.modules.report.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ReportResponseDTOphone(

        String phone,
        LocalDateTime callDate,
        String company,
        String description
) {

}