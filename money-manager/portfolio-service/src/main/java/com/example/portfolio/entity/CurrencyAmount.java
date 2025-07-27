package com.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

@Embeddable
@Data
public class CurrencyAmount {
    private String currency;
    private double amount;
}