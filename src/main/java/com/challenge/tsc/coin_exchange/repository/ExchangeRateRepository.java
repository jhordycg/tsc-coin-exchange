package com.challenge.tsc.coin_exchange.repository;

import com.challenge.tsc.coin_exchange.entity.ExchangeRate;
import com.challenge.tsc.coin_exchange.entity.enums.CurrencyType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> getFirstByCurrencyOrderByUpdatedAtAsc(CurrencyType currency);
}
