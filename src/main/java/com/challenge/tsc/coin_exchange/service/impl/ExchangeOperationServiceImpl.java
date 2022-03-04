package com.challenge.tsc.coin_exchange.service.impl;

import com.challenge.tsc.coin_exchange.dto.ExchangeOperationResponseDto;
import com.challenge.tsc.coin_exchange.dto.ExchangeRateResponseDto;
import com.challenge.tsc.coin_exchange.entity.ExchangeOperation;
import com.challenge.tsc.coin_exchange.entity.ExchangeRate;
import com.challenge.tsc.coin_exchange.repository.ExchangeOperationRepository;
import com.challenge.tsc.coin_exchange.service.ExchangeOperationService;
import com.challenge.tsc.coin_exchange.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ExchangeOperationServiceImpl implements ExchangeOperationService {
    private final ExchangeOperationRepository repository;
    private final ExchangeRateService rateService;

    @Override
    public ExchangeOperationResponseDto exchange(ExchangeOperation operation) {
        var response = new ExchangeOperationResponseDto();
        //encontrar el tipo de cambio
        Optional<ExchangeRate> exchangeType = rateService.findByCurrency(operation.getTargetCurrency());
        if (exchangeType.isPresent()) {
            var exchangeTypeDto = new ExchangeRateResponseDto();
            BeanUtils.copyProperties(exchangeType.get(), exchangeTypeDto);
            response.setOperationId(operation.getUuid());
            response.setExchangeRate(exchangeTypeDto);
            response.setAmount(operation.getAmount());
            response.setSourceCurrency(operation.getSourceCurrency());
            response.setTargetCurrency(operation.getTargetCurrency());

            // Se calcula la cantidad de dinero que se quiere comparar * el costo
            // del tipo de cambio a la venta de dicha moneda.
            response.setAmountWithRate(operation.getAmount() * exchangeTypeDto.getPurchasePrice());
            return response;
        } else return null;
    }

    @Override
    public ExchangeOperation create(ExchangeOperation exchangeOperation) {
        return repository.save(exchangeOperation);
    }

    @Override
    public Optional<ExchangeOperation> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<ExchangeOperation> findAll() {
        return repository.findAll();
    }
}
