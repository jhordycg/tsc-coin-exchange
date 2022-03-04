package com.challenge.tsc.coin_exchange.controller;

import com.challenge.tsc.coin_exchange.dto.ExchangeOperationDto;
import com.challenge.tsc.coin_exchange.dto.ExchangeOperationResponseDto;
import com.challenge.tsc.coin_exchange.entity.ExchangeOperation;
import com.challenge.tsc.coin_exchange.service.ExchangeOperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@PreAuthorize("hasAuthority('SCOPE_user')")
@RequestMapping("operations")
@RequiredArgsConstructor
public class ExchangeOperationController {
    private final ExchangeOperationService service;

    @PostMapping
    public ResponseEntity<ExchangeOperationResponseDto> create(@RequestBody ExchangeOperationDto operationDto) {
        var operation = new ExchangeOperation();
        BeanUtils.copyProperties(operationDto, operation);
        return ResponseEntity.ok(service.exchange(operation));
    }
}
