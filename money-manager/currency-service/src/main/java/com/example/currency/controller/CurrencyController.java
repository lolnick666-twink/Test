package com.example.currency.controller;

import com.example.currency.dto.CurrencyDto;
import com.example.currency.dto.ExchangeRateRequest;
import com.example.currency.service.CurrencyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/currency")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/rate")
    public CurrencyDto getExchangeRate(@RequestBody ExchangeRateRequest request) {
        return currencyService.getExchangeRate(request.getFrom(), request.getTo());
    }
}