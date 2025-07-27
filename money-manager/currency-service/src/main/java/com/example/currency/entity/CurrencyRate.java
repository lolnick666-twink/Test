package com.example.currency.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CurrencyRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fromCurrency;
    private String toCurrency;
    private double rate;
}