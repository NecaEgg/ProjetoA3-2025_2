package br.com.safe_line.safeline.modules.report.exception;

public class ReportNotFoundException extends RuntimeException {
    public ReportNotFoundException() {
        super("Report not found");
    }
}
