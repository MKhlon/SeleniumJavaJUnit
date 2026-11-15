package org.example.automation.components;

import org.example.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseTable<T extends BaseTable<T>> extends BasePage {
    //self-referential generic pattern (CRTP-F-bounded polymorphism) to allow base-class methods return
    //the concrete subclass type instead of just BaseTable

    private final T t;

    public BaseTable(WebDriver driver) {
        super(driver);
        t = (T) this;
    }

    //return element containing table html element
    protected abstract By getTableElement();

    //return list of column names
    protected abstract List<String> getColumns();

    //get index of name column. Index starts at 1, like td[1]...
    public int getColumnIndex(String columnName) {
        var column = getColumns().stream()
                .filter(name -> name.equalsIgnoreCase(columnName))
                .findFirst()
                .orElseThrow(
                        () -> new IllegalArgumentException("Column " + columnName
                                + " not found in table " + getTableElement().toString()));
        return getColumns().indexOf(column) + 1;
    }

    protected String getCellLocator(int columnIndex, int rowIndex) {
        return "tbody/tr[" + rowIndex + "]/td[" + columnIndex + "]";
    }

    public WebElement getCellElement(int columnIndex, int rowIndex) {
        return waitUtils.waitForElementToBeVisible(getTableElement())
                .findElement(By.xpath(getCellLocator(columnIndex, rowIndex)));
    }

    protected List<WebElement> getRows() {
        return waitUtils.waitForElementToBeVisible(getTableElement())
                .findElements(By.cssSelector("tbody/tr"));
    }

    public String getCellText(int columnIndex, int rowIndex) {
        return getCellElement(columnIndex, rowIndex).getText();
    }

    public String getCellText(String columnName, int rowIndex) {
        return getCellText(getColumnIndex(columnName), rowIndex);
    }

    public List<List<String>> getTableData() {
        List<List<String>> tableDataList = new ArrayList<>();
        for(WebElement row : getRows()) {
            List<String> rowDataList = new ArrayList<>();
            for(WebElement cell : row.findElements(By.xpath("td"))) {
                rowDataList.add(cell.getText());
            }
            tableDataList.add(rowDataList);
        }
        return tableDataList;
    }
}
