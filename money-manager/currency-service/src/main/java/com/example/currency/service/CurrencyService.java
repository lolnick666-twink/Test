package com.example.currency.service;

import com.example.currency.dto.CurrencyDto;
import com.example.currency.entity.CurrencyRate;
import com.example.currency.mapper.CurrencyMapper;
import com.example.currency.repository.CurrencyRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final ExternalApiService externalApiService;
    private final CurrencyMapper currencyMapper = CurrencyMapper.INSTANCE;

    public CurrencyService(CurrencyRepository currencyRepository, ExternalApiService externalApiService) {
        this.currencyRepository = currencyRepository;
        this.externalApiService = externalApiService;
    }

    public CurrencyDto getExchangeRate(String from, String to) {
        // ✅ ПРАВИЛЬНО: Обрабатываем Optional
        CurrencyRate rate = currencyRepository.findByFromCurrencyAndToCurrency(from, to)
                .orElseThrow(() -> new RuntimeException("Курс не найден для " + from + " → " + to));
        return currencyMapper.toDto(rate);
    }

    @Scheduled(fixedRate = 600000) // 10 минут
    public void updateRatesFromExternalApis() {
        List<CurrencyDto> rates = externalApiService.fetchAllRates();
        currencyRepository.deleteAll();
        currencyRepository.saveAll(rates.stream()
                .map(currencyMapper::toEntity)
                .toList());
    }
}