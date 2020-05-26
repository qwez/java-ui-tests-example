package ru.awg.examples.uitest.util;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

public abstract class PropertiesReader {

    public static Properties read(String file) throws IOException {
        Properties props = new Properties();
        props.load(
                Optional
                        .ofNullable(PropertiesReader.class.getClassLoader().getResourceAsStream(file))
                        .orElseThrow()
        );
        return props;

    }
}
