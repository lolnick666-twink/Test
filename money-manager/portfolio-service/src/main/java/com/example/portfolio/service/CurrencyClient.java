package com.example.portfolio.service;

import com.example.portfolio.dto.ExchangeRateRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "currency-service", url = "${currency.service.url}")
public interface CurrencyClient {

    @PostMapping
    ExchangeRateRequest getExchangeRate(String from, String to);
}