package com.example.portfolio.dto;

import lombok.Data;
import java.util.Map;

@Data
public class PortfolioDto {
    private String userId;
    private Map<String, Double> currencies;
    private double totalValue;
}