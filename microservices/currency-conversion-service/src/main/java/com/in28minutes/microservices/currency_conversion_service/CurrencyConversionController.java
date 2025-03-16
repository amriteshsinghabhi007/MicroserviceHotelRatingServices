package com.in28minutes.microservices.currency_conversion_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeProxy proxy;

    //http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
            ){
        HashMap<String,String> uriVaribales = new HashMap<>();
        uriVaribales.put("from",from);
        uriVaribales.put("to",to);
        ResponseEntity<CurrencyConversion> responseEntity =new RestTemplate().getForEntity
                ("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVaribales);
       CurrencyConversion currencyConversion= responseEntity.getBody();
        return new CurrencyConversion(currencyConversion.getId(),from,to,quantity,currencyConversion.getConversionMutiple(),quantity.multiply(currencyConversion.getConversionMutiple()),currencyConversion.getEnvironment()+" "+ " REST TEMPLATE ");
    }
    //http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10
    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ){
        CurrencyConversion currencyConversion = proxy.retriveExchangeValue(from, to);
        return new CurrencyConversion(currencyConversion.getId(),from,to,quantity,currencyConversion.getConversionMutiple(),quantity.multiply(currencyConversion.getConversionMutiple()),currencyConversion.getEnvironment()+" "+ " feign ");
    }
}
