package org.example.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WebTable extends BaseTable<WebTable> {
    public static final String FIRST_NAME = "First Name";
    public static final String LAST_NAME = "Last Name";
    public static final String AGE = "Age";
    public static final String EMAIL = "Email";
    public static final String SALARY = "Salary";
    public static final String DEPARTMENT = "Department";
    public static final String ACTION = "Action";

    private final By tableLocator = By.cssSelector("table.table");

    public WebTable(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getTableElement() {
        return tableLocator;
    }

    @Override
    protected List<String> getColumns() {
        return new ArrayList<>(List.of(
            FIRST_NAME,
            LAST_NAME,
            AGE,
            EMAIL,
            SALARY,
            DEPARTMENT,
            ACTION
        ));
    }
}
