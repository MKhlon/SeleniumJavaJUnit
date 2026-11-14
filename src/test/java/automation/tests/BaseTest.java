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

    @BeforeEach
    void setUp() {
        log.info("Starting test");
        DriverFactory.initDriver();
    }

    @AfterEach
    void tearDown() {
        DriverFactory.quitDriver();
        log.info("Test finished");
    }

    protected WebDriver driver() {
        return DriverFactory.getDriver();
    }
}
