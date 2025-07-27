package com.example.portfolio.service;

// ИСПРАВЛЕНО: Правильный импорт из currency-service
import com.example.currency.dto.CurrencyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "currency-service", url = "${currency.service.url}")
public interface CurrencyClient {

    // ИСПРАВЛЕНО: POST + RequestBody + возвращаем CurrencyDto
    @PostMapping
    CurrencyDto getExchangeRate(@RequestBody CurrencyDto request);
}