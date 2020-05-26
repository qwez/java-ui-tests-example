package ru.awg.examples.uitest.model;

import lombok.Data;

@Data
public class CurrencyExchangeRate {
    private final String name;
    private final Double buy;
    private final Double sell;
}
