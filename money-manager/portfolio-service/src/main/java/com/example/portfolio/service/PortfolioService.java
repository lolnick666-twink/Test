package com.example.portfolio.service;

import com.example.portfolio.dto.CurrencyAmountDto;
import com.example.portfolio.dto.PortfolioDto;
import com.example.portfolio.dto.PortfolioValueRequest;
import com.example.portfolio.entity.Portfolio;
import com.example.portfolio.entity.User;
import com.example.portfolio.mapper.PortfolioMapper;
import com.example.portfolio.repository.PortfolioRepository;
import com.example.portfolio.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;
    private final CurrencyClient currencyClient;
    private final PortfolioMapper portfolioMapper = PortfolioMapper.INSTANCE;

    public PortfolioService(PortfolioRepository portfolioRepository, UserRepository userRepository, CurrencyClient currencyClient) {
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
        this.currencyClient = currencyClient;
    }

    public void addCurrency(String currency, double amount) {
        // Логика добавления валюты
    }

    public void removeCurrency(String currency, double amount) {
        // Логика удаления валюты
    }

    public double getPortfolioValue(String userId, String portfolioId, String targetCurrency) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow();
        return portfolio.getCurrencies().entrySet().stream()
                .mapToDouble(entry -> {
                    double rate = currencyClient.getExchangeRate(entry.getKey(), targetCurrency).getRate();
                    return entry.getValue() * rate;
                })
                .sum();
    }

    public PortfolioDto getPortfolio(String userId, String portfolioId) {
        Portfolio portfolio = portfolioRepository.findById(portfolioId).orElseThrow();
        return portfolioMapper.toDto(portfolio);
    }
}