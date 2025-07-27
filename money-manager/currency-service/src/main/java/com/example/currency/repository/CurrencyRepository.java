package com.example.currency.repository;

import com.example.currency.entity.CurrencyRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<CurrencyRate, Long> {
    Optional<CurrencyRate> findByFromCurrencyAndToCurrency(String from, String to);
}