package com.challenge.tsc.coin_exchange.repository;

import com.challenge.tsc.coin_exchange.entity.ExchangeOperation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeOperationRepository extends CrudRepository<ExchangeOperation, Long> {
}
