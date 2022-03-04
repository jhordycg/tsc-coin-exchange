package com.challenge.tsc.coin_exchange.service;

import com.challenge.tsc.coin_exchange.entity.ExchangeRate;
import com.challenge.tsc.coin_exchange.entity.enums.CurrencyType;

import java.util.Optional;

public interface ExchangeRateService {
    ExchangeRate create(ExchangeRate exchangeRate);

    ExchangeRate update(ExchangeRate exchangeRate);

    Optional<ExchangeRate> findOneById(Long id);

    Optional<ExchangeRate> findByCurrency(CurrencyType currency);

    Iterable<ExchangeRate> findAll();
}
