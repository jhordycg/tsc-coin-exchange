package com.challenge.tsc.coin_exchange.dto;

import com.challenge.tsc.coin_exchange.entity.enums.CurrencyType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExchangeRateDto {
    private String description;
    private CurrencyType currency;
    private Double salePrice;
    private Double purchasePrice;
}
