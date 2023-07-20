package testTask.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestingChallengeModel extends BasePage {

    public TestingChallengeModel(WebDriver driver) {
        super(driver);
    }
    protected By cnpNumberInputLocator = By.cssSelector("form .inputbox");
    protected By titleLocator = By.cssSelector("body h1");
    protected By checkValidityButtonLocator = By.className("button");
    protected By valueTestedLocator = By.className("values-tested");

    protected By congratMessageLocator = By.xpath("//font[contains(text(), 'YOU HAVE DONE IT')]");

    public boolean isTitleVisible() {
        WebElement titleElement = findWebElement(titleLocator);
        waitForElementToBeVisible(titleElement);
        return titleElement.isDisplayed();
    }

    public void submitCnpOfThePerson(long cnp) {
        WebElement cnpNumberInput = findWebElement(cnpNumberInputLocator);
        WebElement checkValidityButton = findWebElement(checkValidityButtonLocator);
        clearAndTypeInto(cnpNumberInput, String.valueOf(cnp));
        checkValidityButton.click();
        waitForElementToBeVisible(findWebElement(titleLocator));
    }
    public String getValueTested() {
        WebElement valueTested = findWebElement(valueTestedLocator);
        return valueTested.getText().trim();
    }
    public boolean isCongratMessageDisplayed() {
        WebElement congratMessage = findWebElement(congratMessageLocator);
        waitForElementToBeVisible(congratMessage);
        return congratMessage.isDisplayed();
    }

}
