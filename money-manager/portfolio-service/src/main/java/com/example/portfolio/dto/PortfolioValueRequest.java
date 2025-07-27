package com.example.portfolio.dto;

import lombok.Data;

@Data
public class PortfolioValueRequest {
    private String userId;
    private String portfolioId;
    private String targetCurrency;
}