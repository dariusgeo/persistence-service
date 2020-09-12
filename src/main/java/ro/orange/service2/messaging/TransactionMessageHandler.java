package ro.orange.service2.messaging;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.orange.service2.config.RabbitMQProperties;
import ro.orange.service2.dto.TransactionDTO;
import ro.orange.service2.service.TransactionService;

@Component
public class TransactionMessageHandler {
    private final Logger logger = LoggerFactory.getLogger(TransactionMessageHandler.class);

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitMQProperties rabbitMQProperties;

    public void handleMessage(String message) {
        logger.info("Message received... ", message);
        TransactionDTO transactionDTO = new Gson().fromJson(message, TransactionDTO.class);
        TransactionDTO result = transactionService.createTransaction(transactionDTO);
        logger.info("Sending saved transaction... ", result.toString());
        String messageToSend = new Gson().toJson(result);
        rabbitTemplate.convertAndSend(rabbitMQProperties.getTxOutgoingExchangeName(), rabbitMQProperties.getTxOutgoingRoutingKey(), messageToSend);
    }

}