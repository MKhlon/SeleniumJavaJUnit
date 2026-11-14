package automation.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoogleTest extends BaseTest {

    @Test
    void shouldOpenGoogle() {
        log.info("Executing google test");
        driver().get("https://www.google.com");

        Assertions.assertTrue(driver().getTitle().contains("Google"));
    }
}
