package ro.orange.service2.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ro.orange.service2.messaging.ReportMessageHandler;
import ro.orange.service2.messaging.TransactionMessageHandler;

@Configuration
public class AMQPConfig {

    @Autowired
    private RabbitMQProperties rabbitMQProperties;


    @Bean
    Queue txOutgoingQueue() {
        return new Queue(rabbitMQProperties.getTxOutgoingQueueName(), false);
    }

    @Bean
    TopicExchange txOutgoingExchange() {
        return new TopicExchange(rabbitMQProperties.getTxOutgoingExchangeName());
    }

    @Bean
    Binding txOutgoingBinding(Queue txOutgoingQueue, TopicExchange txOutgoingExchange) {
        return BindingBuilder.bind(txOutgoingQueue).to(txOutgoingExchange).with(rabbitMQProperties.getTxOutgoingRoutingKey());
    }

    @Bean
    Queue txIncomingQueue() {
        return new Queue(rabbitMQProperties.getTxIncomingQueueName(), false);
    }

    @Bean
    TopicExchange txIncomingExchange() {
        return new TopicExchange(rabbitMQProperties.getTxIncomingExchangeName());
    }

    @Bean
    Binding txIncomingBinding(Queue txIncomingQueue, TopicExchange txIncomingExchange) {
        return BindingBuilder.bind(txIncomingQueue).to(txIncomingExchange).with(rabbitMQProperties.getTxIncomingRoutingKey());
    }

    @Bean
    Queue reportOutgoingQueue() {
        return new Queue(rabbitMQProperties.getReportIncomingQueueName(), false);
    }

    @Bean
    TopicExchange reportOutgoingExchange() {
        return new TopicExchange(rabbitMQProperties.getReportOutgoingExchangeName());
    }

    @Bean
    Binding reportOutgoingBinding(Queue reportOutgoingQueue, TopicExchange reportOutgoingExchange) {
        return BindingBuilder.bind(reportOutgoingQueue).to(reportOutgoingExchange).with(rabbitMQProperties.getReportOutgoingRoutingKey());
    }

    @Bean
    Queue reportIncomingQueue() {
        return new Queue(rabbitMQProperties.getReportIncomingQueueName(), false);
    }

    @Bean
    TopicExchange reportIncomingExchange() {
        return new TopicExchange(rabbitMQProperties.getReportIncomingExchangeName());
    }

    @Bean
    Binding reportIncomingBinding(Queue reportIncomingQueue, TopicExchange reportIncomingExchange) {
        return BindingBuilder.bind(reportIncomingQueue).to(reportIncomingExchange).with(rabbitMQProperties.getReportIncomingRoutingKey());
    }

    @Bean
    SimpleMessageListenerContainer transactionContainer(ConnectionFactory connectionFactory,
                                                        @Qualifier(value = "transactionListenerAdapter") MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(rabbitMQProperties.getTxIncomingQueueName());
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    SimpleMessageListenerContainer reportContainer(ConnectionFactory connectionFactory,
                                                   @Qualifier (value = "reportListenerAdapter") MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(rabbitMQProperties.getReportIncomingQueueName());
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter transactionListenerAdapter(TransactionMessageHandler receiver) {
        return new MessageListenerAdapter(receiver);
    }

    @Bean
    MessageListenerAdapter reportListenerAdapter(ReportMessageHandler receiver) {
        return new MessageListenerAdapter(receiver);
    }

}