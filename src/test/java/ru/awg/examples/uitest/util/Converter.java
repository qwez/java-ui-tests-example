package ru.awg.examples.uitest.util;

import lombok.SneakyThrows;
import java.text.NumberFormat;
import java.util.Locale;

public abstract class Converter {

    @SneakyThrows
    public static Double parseCurrencyAmount(String source) {
        NumberFormat format = NumberFormat.getInstance(new Locale("ru"));
        return format.parse(source).doubleValue();
    }
}
