package org.example.automation.drivers;

import org.example.automation.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.time.Duration;
import java.util.Locale;

public final class DriverFactory {

    private static final Logger log =
            LoggerFactory.getLogger(DriverFactory.class);
    private DriverFactory() {
    }

    public static WebDriver createDriver() {
        String browser = ConfigReader.get("browser", "chrome")
                .toLowerCase(Locale.ROOT);
        boolean headless = ConfigReader.getBoolean("headless", false);

        log.info("Initializing browser: {}", browser);

        WebDriver driver = switch (browser) {
            case "chrome" -> createChrome(headless);
            case "chromium" -> createChromium(headless);
            case "edge" -> createEdge(headless);
            case "firefox" -> createFirefox(headless);
            case "safari" -> createSafari(headless);
            default -> throw new IllegalArgumentException(
                    "Unsupported browser: " + browser
            );
        };

        try {
            driver.manage().timeouts()
                    .implicitlyWait(Duration.ZERO);

            if (headless) {
                driver.manage().window().setSize(
                        new org.openqa.selenium.Dimension(1920, 1080));
            } else {
                driver.manage().window().maximize();
            }

            log.info("WebDriver initialized successfully");
            return driver;
        } catch (RuntimeException e) {
            try {
                driver.quit();
            } catch (RuntimeException cleanupFailure) {
                e.addSuppressed(cleanupFailure);
            }
            throw e;
        }
    }

    private static WebDriver createChrome(boolean headless) {
        ChromeOptions options = new ChromeOptions();

        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        return new ChromeDriver(options);
    }

    private static WebDriver createChromium(boolean headless) {
        ChromeOptions options = new ChromeOptions();

        String binary = ConfigReader.getOptional("chromium.binary");

        if (binary == null) {
            throw new IllegalArgumentException(
                    "Specify Chromium binary using -Dchromium.binary"
            );
        }

        options.setBinary(Path.of(binary).toFile());

        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        return new ChromeDriver(options);
    }

    private static WebDriver createEdge(boolean headless) {
        EdgeOptions options = new EdgeOptions();

        if (headless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        return new EdgeDriver(options);
    }

    private static WebDriver createFirefox(boolean headless) {
        FirefoxOptions options = new FirefoxOptions();

        if (headless) {
            options.addArguments("-headless");
        }

        return new FirefoxDriver(options);
    }

    private static WebDriver createSafari(boolean headless) {
        if (headless) {
            throw new UnsupportedOperationException(
                    "Safari does not support headless mode");
        }

        return new SafariDriver();
    }

}
