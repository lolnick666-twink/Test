package com.example.portfolio.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Entity
@Data
public class Portfolio {
    @Id
    private String id;
    @ElementCollection
    private Map<String, Double> currencies;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}