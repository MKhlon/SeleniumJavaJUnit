package org.example.automation.pages.elements;


import org.example.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ButtonsComponent extends BasePage {
   private final By doubleClickButton = By.id("doubleClickBtn");
   private final By doubleClickButtonMessage = By.id("doubleClickMessage");

   public ButtonsComponent(WebDriver driver) {
      super(driver);
   }

   public void clickDoubleClickButton() {
      doubleClick(doubleClickButton);
   }

   public String getDoubleClickButtonMessage() {
      return getText(doubleClickButtonMessage);
   }

 }
