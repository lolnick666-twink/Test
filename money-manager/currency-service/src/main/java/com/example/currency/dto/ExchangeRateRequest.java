package com.example.currency.dto;

import lombok.Data;

@Data
public class ExchangeRateRequest {
    private String from;
    private String to;
}