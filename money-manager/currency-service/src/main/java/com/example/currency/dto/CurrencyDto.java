package com.example.currency.dto;

import lombok.Data;

@Data
public class CurrencyDto {
    private String fromCurrency;
    private String toCurrency;
    private double rate;
}