package automation.steps.elements;

import automation.steps.BaseSteps;
import org.assertj.core.api.SoftAssertions;
import org.example.automation.components.RegistrationFormComponent;
import org.example.automation.components.WebTable;
import org.example.automation.pages.elements.ElementsPage;
import org.openqa.selenium.WebDriver;

public class WebTablesSteps extends BaseSteps {

    private final ElementsPage elementsPage;

    public WebTablesSteps(WebDriver driver) {
        super(driver);
        this.elementsPage = new ElementsPage(driver);
    }

    public RegistrationFormComponent editRecord() {
        return elementsPage.getWebTablesPage().clickEdit();
    }

    public void verifyRecordUpdated(String firstName, String lastName, int rowIndex) {
        var actualFirstName = elementsPage.getWebTablesPage().getWebTable().getCellText(
                WebTable.FIRST_NAME, rowIndex);
        var actualLastName = elementsPage.getWebTablesPage().getWebTable().getCellText(
                WebTable.LAST_NAME, rowIndex);
        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(actualFirstName)
                    .as("First name in the table is not as expected")
                    .isEqualTo(firstName);
            softly.assertThat(actualLastName)
                    .as("Last name in the table is not as expected")
                    .isEqualTo(lastName);
        });
    }
}
