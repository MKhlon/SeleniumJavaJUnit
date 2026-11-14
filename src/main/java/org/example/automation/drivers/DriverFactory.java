package org.example.automation.drivers;

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
   //ThreadLocal<WebDriver> prepares your framework for parallel execution.
   // Each thread has its own driver reference, preventing concurrent tests
   // from sharing one browser session.
    private static final ThreadLocal<WebDriver> DRIVER =
            new ThreadLocal<>();

    private DriverFactory() {
    }

    public static void initDriver() {
        if (DRIVER.get() != null) {
            throw new IllegalStateException(
                    "WebDriver already initialized for this thread");
        }

        String browser = System.getProperty(
                "browser", "chrome"
        ).toLowerCase(Locale.ROOT);

        boolean headless = Boolean.parseBoolean(
                System.getProperty("headless", "false")
        );

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

            if (!headless) {
                driver.manage().window().maximize();
            }

            DRIVER.set(driver);

            log.info("WebDriver initialized successfully");
        } catch (RuntimeException e) {
            driver.quit();
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

        String binary = System.getProperty("chromium.binary");

        if (binary == null || binary.isBlank()) {
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

        WebDriver driver = new FirefoxDriver(options);

        if (headless) {
            driver.manage().window()
                    .setSize(new org.openqa.selenium.Dimension(1920, 1080));
        }

        return driver;
    }

    private static WebDriver createSafari(boolean headless) {
        if (headless) {
            throw new UnsupportedOperationException(
                    "Safari does not support headless mode");
        }

        return new SafariDriver();
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();

        if (driver == null) {
            throw new IllegalStateException(
                    "WebDriver has not been initialized");
        }

        return driver;
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();

        try {
            if (driver != null) {
                driver.quit();
                log.info("WebDriver session closed");
            }
        } finally {
            DRIVER.remove();
        }
    }
}
