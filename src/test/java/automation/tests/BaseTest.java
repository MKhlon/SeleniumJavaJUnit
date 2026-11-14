package automation.tests;


import org.example.automation.drivers.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseTest {

    protected final Logger log =
            LoggerFactory.getLogger(getClass());
    private WebDriver webDriver;

    @BeforeEach
    void setUp() {
        log.info("Starting test");
        webDriver = DriverFactory.createDriver();
    }

    @AfterEach
    void tearDown() {
        try {
            if (webDriver != null) {
                webDriver.quit();
            }
        } finally {
            webDriver = null;
            log.info("Test finished");
        }
    }

    protected WebDriver driver() {
        if (webDriver == null) {
            throw new IllegalStateException(
                    "WebDriver has not been initialized");
        }
        return webDriver;
    }
}
