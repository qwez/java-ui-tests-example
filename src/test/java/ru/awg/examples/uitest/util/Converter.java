package ru.awg.examples.uitest.util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public abstract class Converter {

    public static Double parseCurrencyAmount(String source) {
        NumberFormat format = NumberFormat.getInstance(new Locale("ru"));
        try {
            return format.parse(source).doubleValue();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
