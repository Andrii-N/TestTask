package testTask.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private final WebDriver driver;
    private final Actions action;
    private final WebDriverWait wait;

    protected WebDriver getDriver(){
        return driver;
    }

    public BasePage (WebDriver driver) {
        this.driver = driver;
        action = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement findWebElement(By by) {
        return driver.findElement(by);
    }

    protected void waitForElementToBeVisible(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            System.out.println(String.format("%s become visible", webElement));
        } catch (TimeoutException ex)
        {
            System.out.println(ex.getLocalizedMessage());
        }
    }

    protected void clearAndTypeInto(WebElement webElement, String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }
}
