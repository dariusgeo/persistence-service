package edu.geodani.persitence.controller;

import edu.geodani.persitence.dto.ReportDTO;
import edu.geodani.persitence.service.ReportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api")
@RequiredArgsConstructor
@Slf4j
public class ReportController {

    private final ReportService reportService;

    @GetMapping(value = "/reports/{cnp}/{iban}")
    public ReportDTO generateReport(@PathVariable(value = "cnp") String cnp, @PathVariable(value = "iban") String iban){
        Assert.notNull(cnp, "CNP value not provided.");
        Assert.notNull(iban, "IBAN value not provided.");

        System.out.println("CNP >> " + cnp + " IBAN >> " + iban);
        log.debug(String.format("generateReport() cnp:: %s , iban:: %s", cnp, iban));
        return reportService.generateReport(cnp, iban);
    }
}
