package edu.geodani.persitence.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
@Data
public class RabbitMQProperties {

    private String txOutgoingQueueName;
    private String txOutgoingExchangeName;
    private String txOutgoingRoutingKey;

    private String txIncomingQueueName;
    private String txIncomingExchangeName;
    private String txIncomingRoutingKey;

    private String reportOutgoingQueueName;
    private String reportOutgoingExchangeName;
    private String reportOutgoingRoutingKey;

    private String reportIncomingQueueName;
    private String reportIncomingExchangeName;
    private String reportIncomingRoutingKey;
}