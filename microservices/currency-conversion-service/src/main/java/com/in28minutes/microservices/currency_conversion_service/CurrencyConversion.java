package com.in28minutes.microservices.currency_conversion_service;
import java.math.BigDecimal;

public class CurrencyConversion {
    private Long id;
    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal conversionMutiple;

    private BigDecimal totalCulculateAmount;
    private String environment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMutiple() {
        return conversionMutiple;
    }

    public void setConversionMutiple(BigDecimal conversionMutiple) {
        this.conversionMutiple = conversionMutiple;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCulculateAmount() {
        return totalCulculateAmount;
    }

    public void setTotalCulculateAmount(BigDecimal totalCulculateAmount) {
        this.totalCulculateAmount = totalCulculateAmount;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public CurrencyConversion(Long id, String from, String to,  BigDecimal quantity, BigDecimal conversionMutiple, BigDecimal totalCulculateAmount, String environment) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.quantity = quantity;
        this.conversionMutiple = conversionMutiple;
        this.totalCulculateAmount = totalCulculateAmount;
        this.environment = environment;
    }

    public CurrencyConversion() {
    }

}
