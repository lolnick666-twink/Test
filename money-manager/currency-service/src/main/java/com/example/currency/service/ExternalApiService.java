package com.example.currency.service;

import com.example.currency.dto.CurrencyDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ExternalApiService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final List<String> apiUrls = List.of("http://api1.com/rates", "http://api2.com/rates");

    public List<CurrencyDto> fetchAllRates() {
        return apiUrls.stream()
                .flatMap(url -> {
                    CurrencyDto[] dtos = restTemplate.getForObject(url, CurrencyDto[].class);
                    return dtos != null ? List.of(dtos).stream() : List.<CurrencyDto>of().stream();
                })
                .toList();
    }
}