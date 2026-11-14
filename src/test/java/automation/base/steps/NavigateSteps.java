package automation.base.steps;

import org.example.automation.config.ConfigReader;
import org.example.automation.pages.BasePage;
import org.example.automation.pages.elements.ButtonsComponent;
import org.example.automation.pages.elements.ElementsPage;
import org.example.automation.pages.elements.TextComponent;
import org.openqa.selenium.By;

public class NavigateSteps extends BaseSteps {
    //Elements
    private final By elementsLink = By.cssSelector("a[href='/elements']");
    private final By buttonsLink =
            By.cssSelector("a[href='/buttons']");
    private final By textComponentLink = By.cssSelector("a[href='/text-box']");

    public void openHomePage() {
        driver.get(ConfigReader.get("base.url"));
    }

    public ElementsPage navigateToElementsPage() {
        click(elementsLink);
        return new ElementsPage();
    }

    public TextComponent navigateToTextComponent() {
        click(textComponentLink);
        return new TextComponent();
    }

    public ButtonsComponent navigateToButtonsComponent() {
        click(buttonsLink);
        return new ButtonsComponent();
    }
}
