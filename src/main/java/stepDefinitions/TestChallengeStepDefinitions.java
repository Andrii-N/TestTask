package stepDefinitions;

import dataProvider.DataInput;
import dataProvider.Person;
import io.cucumber.java.After;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testTask.ChromeBrowser;
import testTask.PageObjects.TestingChallengeModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class TestChallengeStepDefinitions {
    private WebDriver driver;
    private TestingChallengeModel testChallengePage;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");


    private List<Person> persons;
    @DataTableType
    public Person personEntry(Map<String, String> entry) {
        return new Person(
                entry.get("gender"),
                LocalDate.parse(entry.get("dateOfBirth"), formatter),
                Boolean.valueOf(entry.get("isForeignResidentInRomania")),
                Boolean.valueOf(entry.get("isNonResident")),
                Integer.parseInt(entry.get("areaCode")),
                entry.get("orderNumber")
        );
    }

    @Given("Testing Challenge URI is open")
    public void testing_challenge_uri_is_open() throws InterruptedException {
        driver = new ChromeBrowser().createChromeDriver();
        driver.get("http://testingchallenges.thetestingmap.org/challenge4.php");
        testChallengePage = new TestingChallengeModel(driver);
    }

    @When("CNP Number is generated for the following five Persons")
    public void cnp_number_is_generated_for_the_following_five_Persons(List<Person> persons) {
        this.persons = persons;
    }

    @Then("title of the page should be visible")
    public void title_of_the_page_should_be_visible() {
        Assert.assertTrue(testChallengePage.isTitleVisible());
    }

    @Then("submit of generated CNPs should be successful")
    public void submit_of_generated_CNPs_should_be_successful()  {
        int validationCount = 0;
        for (Person person : persons) {
            DataInput dataInput = new DataInput(person);
            testChallengePage.submitCnpOfThePerson(dataInput.getCnp());
            validationCount++;
            if (validationCount < 5) {
                Assert.assertTrue(testChallengePage.getValueTested().equals(String.valueOf(validationCount)));
            }

        }
    }

    @Then("Congratulation message should be displayed")
    public void congratulation_message_should_be_displayed() {
        Assert.assertTrue(testChallengePage.isCongratMessageDisplayed() == true);
    }
    @After()
    public void closeBrowser() {
        driver.quit();
    }


}
