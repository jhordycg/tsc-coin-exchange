package com.challenge.tsc.coin_exchange.entity;

import com.challenge.tsc.coin_exchange.entity.enums.CurrencyType;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
public class ExchangeOperation {
    @GeneratedValue
    private @Id Long id;
    private UUID uuid;
    private Double amount;
    private CurrencyType sourceCurrency;
    private CurrencyType targetCurrency;

    public UUID getUuid() {
        return UUID.randomUUID();
    }
}
