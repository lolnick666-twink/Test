package com.example.portfolio.controller;

import com.example.portfolio.dto.CurrencyAmountDto;
import com.example.portfolio.dto.PortfolioDto;
import com.example.portfolio.dto.PortfolioValueRequest;
import com.example.portfolio.service.PortfolioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @PostMapping("/add")
    public void addCurrency(@RequestBody CurrencyAmountDto dto) {
        portfolioService.addCurrency(dto.getCurrency(), dto.getAmount());
    }

    @PostMapping("/remove")
    public void removeCurrency(@RequestBody CurrencyAmountDto dto) {
        portfolioService.removeCurrency(dto.getCurrency(), dto.getAmount());
    }

    @PostMapping("/value")
    public double getPortfolioValue(@RequestBody PortfolioValueRequest request) {
        return portfolioService.getPortfolioValue(request.getUserId(), request.getPortfolioId(), request.getTargetCurrency());
    }

    @GetMapping("/{userId}/{portfolioId}")
    public PortfolioDto getPortfolio(@PathVariable String userId, @PathVariable String portfolioId) {
        return portfolioService.getPortfolio(userId, portfolioId);
    }
}