package edu.geodani.persitence.messaging;

import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.geodani.persitence.config.RabbitMQProperties;
import edu.geodani.persitence.dto.TransactionDTO;
import edu.geodani.persitence.service.TransactionService;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransactionMessageHandler {

    private final TransactionService transactionService;

    private final RabbitTemplate rabbitTemplate;

    private final RabbitMQProperties rabbitMQProperties;

    public void handleMessage(String message) {
        log.debug("Message received... ", message);
        TransactionDTO transactionDTO = new Gson().fromJson(message, TransactionDTO.class);
        TransactionDTO result = transactionService.createTransaction(transactionDTO);
        log.debug("Sending saved transaction... ", result.toString());
        String messageToSend = new Gson().toJson(result);
        rabbitTemplate.convertAndSend(rabbitMQProperties.getTxOutgoingExchangeName(), rabbitMQProperties.getTxOutgoingRoutingKey(), messageToSend);
    }

}