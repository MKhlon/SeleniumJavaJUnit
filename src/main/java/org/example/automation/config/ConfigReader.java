package org.example.automation.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new IllegalStateException(
                        "config.properties file not found");
            }

            PROPERTIES.load(input);

        } catch (IOException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private ConfigReader() {
    }

    public static String get(String key) {
        return get(key, null);
    }

    public static String get(String key, String defaultValue) {
        String value = System.getProperty(key);
        if (value == null) {
            value = PROPERTIES.getProperty(key, defaultValue);
        }
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "Missing configuration value: " + key);
        }
        return value.trim();
    }

    public static String getOptional(String key) {
        String value = System.getProperty(key);
        if (value == null) {
            value = PROPERTIES.getProperty(key);
        }
        return value == null || value.isBlank() ? null : value.trim();
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        String value = get(key, Boolean.toString(defaultValue));
        if (!value.equalsIgnoreCase("true")
                && !value.equalsIgnoreCase("false")) {
            throw new IllegalArgumentException(
                    "Configuration value must be true or false: " + key);
        }
        return Boolean.parseBoolean(value);
    }

    public static int getPositiveInt(String key, int defaultValue) {
        final int value;
        try {
            value = Integer.parseInt(get(key, Integer.toString(defaultValue)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "Configuration value must be a positive integer: " + key, e);
        }
        if (value <= 0) {
            throw new IllegalArgumentException(
                    "Configuration value must be a positive integer: " + key);
        }
        return value;
    }
}
