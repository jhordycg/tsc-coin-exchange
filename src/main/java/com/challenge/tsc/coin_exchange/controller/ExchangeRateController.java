package com.challenge.tsc.coin_exchange.controller;

import com.challenge.tsc.coin_exchange.dto.ExchangeRateDto;
import com.challenge.tsc.coin_exchange.entity.ExchangeRate;
import com.challenge.tsc.coin_exchange.entity.enums.CurrencyType;
import com.challenge.tsc.coin_exchange.service.ExchangeRateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("rates")
@PreAuthorize("hasAuthority('SCOPE_admin')")
@RequiredArgsConstructor
public class ExchangeRateController {
    private final ExchangeRateService service;

    @PostMapping
    public ExchangeRate create(@RequestBody ExchangeRateDto exchangeRate) {
        var entity = new ExchangeRate();
        BeanUtils.copyProperties(exchangeRate, entity);
        return service.create(entity);
    }

    @PutMapping
    public ExchangeRate update(@RequestBody ExchangeRateDto exchangeRate) {
        var entity = new ExchangeRate();
        BeanUtils.copyProperties(exchangeRate, entity);
        return service.update(entity);
    }

    @PreAuthorize("hasAuthority('SCOPE_user')")
    @GetMapping
    public Optional<ExchangeRate> findByCurrency(@RequestParam("currencyType") CurrencyType currencyType) {
        return service.findByCurrency(currencyType);
    }
}
