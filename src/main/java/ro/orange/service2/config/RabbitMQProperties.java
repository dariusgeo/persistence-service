package ro.orange.service2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rabbitmq")
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

    public String getTxOutgoingQueueName() {
        return txOutgoingQueueName;
    }

    public void setTxOutgoingQueueName(String txOutgoingQueueName) {
        this.txOutgoingQueueName = txOutgoingQueueName;
    }

    public String getTxOutgoingExchangeName() {
        return txOutgoingExchangeName;
    }

    public void setTxOutgoingExchangeName(String txOutgoingExchangeName) {
        this.txOutgoingExchangeName = txOutgoingExchangeName;
    }

    public String getTxOutgoingRoutingKey() {
        return txOutgoingRoutingKey;
    }

    public void setTxOutgoingRoutingKey(String txOutgoingRoutingKey) {
        this.txOutgoingRoutingKey = txOutgoingRoutingKey;
    }

    public String getTxIncomingQueueName() {
        return txIncomingQueueName;
    }

    public void setTxIncomingQueueName(String txIncomingQueueName) {
        this.txIncomingQueueName = txIncomingQueueName;
    }

    public String getTxIncomingExchangeName() {
        return txIncomingExchangeName;
    }

    public void setTxIncomingExchangeName(String txIncomingExchangeName) {
        this.txIncomingExchangeName = txIncomingExchangeName;
    }

    public String getTxIncomingRoutingKey() {
        return txIncomingRoutingKey;
    }

    public void setTxIncomingRoutingKey(String txIncomingRoutingKey) {
        this.txIncomingRoutingKey = txIncomingRoutingKey;
    }

    public String getReportOutgoingQueueName() {
        return reportOutgoingQueueName;
    }

    public void setReportOutgoingQueueName(String reportOutgoingQueueName) {
        this.reportOutgoingQueueName = reportOutgoingQueueName;
    }

    public String getReportOutgoingExchangeName() {
        return reportOutgoingExchangeName;
    }

    public void setReportOutgoingExchangeName(String reportOutgoingExchangeName) {
        this.reportOutgoingExchangeName = reportOutgoingExchangeName;
    }

    public String getReportOutgoingRoutingKey() {
        return reportOutgoingRoutingKey;
    }

    public void setReportOutgoingRoutingKey(String reportOutgoingRoutingKey) {
        this.reportOutgoingRoutingKey = reportOutgoingRoutingKey;
    }

    public String getReportIncomingQueueName() {
        return reportIncomingQueueName;
    }

    public void setReportIncomingQueueName(String reportIncomingQueueName) {
        this.reportIncomingQueueName = reportIncomingQueueName;
    }

    public String getReportIncomingExchangeName() {
        return reportIncomingExchangeName;
    }

    public void setReportIncomingExchangeName(String reportIncomingExchangeName) {
        this.reportIncomingExchangeName = reportIncomingExchangeName;
    }

    public String getReportIncomingRoutingKey() {
        return reportIncomingRoutingKey;
    }

    public void setReportIncomingRoutingKey(String reportIncomingRoutingKey) {
        this.reportIncomingRoutingKey = reportIncomingRoutingKey;
    }
}