package com.challenge.tsc.coin_exchange.service.impl;

import com.challenge.tsc.coin_exchange.entity.ExchangeRate;
import com.challenge.tsc.coin_exchange.entity.enums.CurrencyType;
import com.challenge.tsc.coin_exchange.service.ExchangeRateService;
import com.challenge.tsc.coin_exchange.repository.ExchangeRateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeRateServiceImpl implements ExchangeRateService {
    private final ExchangeRateRepository repository;

    @Override
    public ExchangeRate create(ExchangeRate exchangeRate) {
        return repository.save(exchangeRate);
    }

    @Override
    public ExchangeRate update(ExchangeRate exchangeRate) {
        return findByCurrency(exchangeRate.getCurrency())
                .map(found -> {
                    found.setPurchasePrice(exchangeRate.getPurchasePrice());
                    found.setSalePrice(found.getSalePrice());
                    return repository.save(found);
                }).orElse(null);
    }

    @Override
    public Optional<ExchangeRate> findOneById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Optional<ExchangeRate> findByCurrency(CurrencyType currency) {
        return repository.getFirstByCurrencyOrderByUpdatedAtAsc(currency);
    }

    @Override
    public Iterable<ExchangeRate> findAll() {
        return repository.findAll();
    }
}
