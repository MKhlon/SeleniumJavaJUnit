package automation.base.steps;

import org.example.automation.pages.elements.ElementsPage;
import org.junit.jupiter.api.Assertions;

import java.util.StringJoiner;


public class TextComponentSteps extends BaseSteps {

    private final ElementsPage elementsPage;
    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;

    public TextComponentSteps() {
        this.elementsPage = new ElementsPage();
    }

    public void enterFullName(String fullName) {
        elementsPage.getTextComponent().setFullName(fullName);
        this.fullName = fullName;
    }

    public void enterEmail(String email) {
        elementsPage.getTextComponent().setEmail(email);
        this.email = email;
    }

    public void verifyOutputText(boolean fullName, boolean email, boolean currentAddress,
                                 boolean permanentAddress) {
        String actualOutput = String.join(
                "\n",
                elementsPage.getTextComponent().getOutputLines()
        );

        StringJoiner expectedOutput = new StringJoiner("\n");

        if (fullName) {
            expectedOutput.add("Name:" + this.fullName);
        }

        if (email) {
            expectedOutput.add("Email:" + this.email);
        }

        if (currentAddress) {
            expectedOutput.add("Current Address :" + this.currentAddress);
        }

        if (permanentAddress) {
            expectedOutput.add("Permanent Address :" + this.permanentAddress);
        }

        Assertions.assertEquals(expectedOutput.toString(), actualOutput);
    }
}
