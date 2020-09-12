package ro.orange.service2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.orange.service2.dto.ReportDTO;
import ro.orange.service2.service.ReportService;

@RestController(value = "/api")
public class ReportController {

    private final Logger logger = LoggerFactory.getLogger(ReportController.class.getName());

    @Autowired
    private ReportService reportService;

    @GetMapping(value = "/reports/{cnp}/{iban}")
    public ReportDTO generateReport(@PathVariable(value = "cnp") String cnp, @PathVariable(value = "iban") String iban){
        Assert.notNull(cnp, "CNP value not provided.");
        Assert.notNull(iban, "IBAN value not provided.");

        System.out.println("CNP >> " + cnp + " IBAN >> " + iban);
        logger.info(String.format("generateReport() cnp:: %s , iban:: %s", cnp, iban));
        return reportService.generateReport(cnp, iban);
    }
}
