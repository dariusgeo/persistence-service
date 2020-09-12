package ro.orange.service2.messaging;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.orange.service2.config.RabbitMQProperties;
import ro.orange.service2.dto.ReportDTO;
import ro.orange.service2.service.ReportService;

@Component
@Deprecated
public class ReportMessageHandler {

    private final Logger logger = LoggerFactory.getLogger(TransactionMessageHandler.class);

    @Autowired
    private ReportService reportService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQProperties rabbitMQProperties;

    public void handleMessage(String message) {
        System.out.println("RECEIVED OBJECT " + message);
        logger.info("Message received... ", message);
        ReportDTO reportDTO = new Gson().fromJson(message, ReportDTO.class);
        ReportDTO result = reportService.generateReport(reportDTO.getCnp(), reportDTO.getIban());
        logger.info("Sending saved transaction... ", result.toString());
        String messageToSend = new Gson().toJson(reportDTO);
        rabbitTemplate.convertAndSend(rabbitMQProperties.getReportOutgoingExchangeName(), rabbitMQProperties.getReportOutgoingRoutingKey(), messageToSend);
    }

}
