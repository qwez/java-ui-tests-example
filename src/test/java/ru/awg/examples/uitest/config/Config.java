package ru.awg.examples.uitest.config;

import ru.awg.examples.uitest.util.PropertiesReader;

import java.io.IOException;
import java.util.Properties;

public class Config {

    public static final Properties properties;

    static {
        try {
            properties = PropertiesReader.read("config.properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
