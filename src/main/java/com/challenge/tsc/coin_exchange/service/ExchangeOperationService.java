package com.challenge.tsc.coin_exchange.service;

import com.challenge.tsc.coin_exchange.dto.ExchangeOperationResponseDto;
import com.challenge.tsc.coin_exchange.entity.ExchangeOperation;

import java.util.Optional;

public interface ExchangeOperationService {
    ExchangeOperationResponseDto exchange(ExchangeOperation exchangeOperation);

    ExchangeOperation create(ExchangeOperation exchangeOperation);

    Optional<ExchangeOperation> findById(Long id);

    Iterable<ExchangeOperation> findAll();
}
