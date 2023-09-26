package testrunner;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import setup.Setup;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class TestRunner extends Setup {

    // Verify that the Ve3.global homepage loads successfully.

    @Test(priority = 2,description = "Checking homepage loading")
    public void testHomepageLoadsSuccessfully(){
        WebElement homePage = driver.findElement(By.xpath("//body/div[@id='outer-wrap']/div[@id='wrap']/main[@id='main']/div[1]/section[1]/div[3]/div[1]/div[1]/div[2]/div[1]/h2[1]"));
        Assert.assertTrue(homePage.isDisplayed());

    }

    // Go to page https://www.ve3.global/news/.

    @Test(priority = 3, description = "Testing navigate To news-page")
    public void testNavigateToNewsPage() throws InterruptedException {

        WebElement menuElement = driver.findElement(new By.ByPartialLinkText("INSIGHTS")); // Update with the actual menu text

        Actions actions = new Actions(driver);

        actions.moveToElement(menuElement).perform();

        WebElement subMenuOption = driver.findElement(new By.ByPartialLinkText("News"));

        subMenuOption.click();

        Thread.sleep(2000);
    }

    // Verify all the elements on the page are displayed

    @Test(priority = 4, description = "Testing elements on news page displayed")
    public void testElementsOnNewsPageDisplayed() throws InterruptedException {
        // Verify that all elements on the News page are displayed
        WebElement pageHeader = driver.findElement(By.tagName("h1"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");

        Thread.sleep(2000);

        WebElement whatsNew = driver.findElement(By.xpath("//h2[contains(text(),\"What's New\")]"));

        JavascriptExecutor jsForWhatsNew = (JavascriptExecutor) driver;
        jsForWhatsNew.executeScript("window.scrollBy(700,780)");

        Thread.sleep(2000);

        WebElement newsletter = driver.findElement(By.xpath("//h2[contains(text(),'Newsletter')]"));

        JavascriptExecutor jsForMI = (JavascriptExecutor) driver;
        jsForMI.executeScript("window.scrollBy(780,781)");

        Thread.sleep(1000);
        WebElement monthlyInsights = driver.findElement(By.xpath("//h3[contains(text(),'Monthly VE3 Insights, Delivered to your Inbox')]"));



        Assert.assertTrue(pageHeader.isDisplayed());
        Assert.assertTrue(whatsNew.isDisplayed());
        Assert.assertTrue(newsletter.isDisplayed());
        Assert.assertTrue(monthlyInsights.isDisplayed());
    }

    // Test the newsletter form by filling it out and submitting it successfully.

    @Test(priority = 5, description = "Testing submit news-letter form successfully")
    public void testSubmitNewsletterFormSuccessfully() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(780,850)");


        WebElement nameField = driver.findElement(By.cssSelector("[name='your-name']"));
        WebElement emailField = driver.findElement(By.cssSelector("[name='your-email']"));

        WebElement submitButton = driver.findElement(By.cssSelector("[type='Submit']"));

        String validName = "Nazrul Islam";
        String validEmail = "youremail@example.com";

        nameField.sendKeys(validName);
        emailField.sendKeys(validEmail);
        submitButton.click();


        //WebElement successMessage = driver.findElement(By.className("wpcf7-response-output"));

        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver,timeout); // Wait for up to 10 seconds
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("wpcf7-response-output")));

        String actualMessage = successMessage.getText();
        String expectedMessage = "Thank you for your message. It has been sent.";
        Assert.assertEquals(actualMessage, expectedMessage, "Success message mismatch");

    }

    // Attempt to submit the newsletter form with invalid data and verify the error message(s).

    @Test(priority = 6, description = "Testing submit news-letter form successfully with invalid data")
    public void testSubmitNewsletterFormWithInvalidData() {

        WebElement nameField = driver.findElement(By.cssSelector("[name='your-name']"));
        WebElement emailField = driver.findElement(By.cssSelector("[name='your-email']"));
        WebElement submitButton = driver.findElement(By.cssSelector("[type='Submit']"));

        String invalidName = "";
        String invalidEmail = "youremail@.com";

        nameField.sendKeys(invalidName);
        emailField.sendKeys(invalidEmail);
        submitButton.click();


        Duration timeout = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        WebElement failedMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'One or more fields have an error. Please check and')]")));

        String actualMessage = failedMessage.getText();
        String expectedMessage = "One or more fields have an error. Please check and try again.";
        Assert.assertEquals(actualMessage, expectedMessage, "Failed message mismatch");
    }

    // Task 3: Data-Driven Testing for Monthly VE3 Insights newsletter form
    @DataProvider(name = "nameEmailDataFromJSON")
    public Iterator<JsonNode[]> getNameEmailDataFromJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode testData = objectMapper.readTree(new File("./src/test/resources/newsletterTestData.json"));

        List<JsonNode[]> data = new ArrayList<>();

        // Convert each test case in JSON to an array of JsonNode
        for (JsonNode testCase : testData) {
            data.add(new JsonNode[]{testCase});
        }

        return data.iterator();
    }

    @Test(priority = 7, dataProvider = "nameEmailDataFromJSON")
    public void testDataDrivenNewsletterFormWithNameAndEmail(JsonNode testData) throws InterruptedException {
        WebElement nameField = driver.findElement(By.cssSelector("[name='your-name']"));
        WebElement emailField = driver.findElement(By.cssSelector("[name='your-email']"));
        WebElement submitButton = driver.findElement(By.cssSelector("[type='Submit']"));

        String name = testData.get("name").asText();
        String email = testData.get("email").asText();

        nameField.clear();
        nameField.sendKeys(name);
        emailField.clear();
        emailField.sendKeys(email);
        submitButton.click();

        Thread.sleep(3000);

        if (email.equals("invalid-email")) {
            String expectedErrorMessage = testData.get("expectedErrorMessage").asText();
            WebElement errorMessage = driver.findElement(By.xpath("//div[contains(text(),'One or more fields have an error. Please check and')]"));
            Assert.assertTrue(errorMessage.isDisplayed());
            Assert.assertTrue(errorMessage.getText().contains(expectedErrorMessage));
        } else {
            WebElement successMessage = driver.findElement(By.className("wpcf7-response-output"));
            Assert.assertTrue(successMessage.isDisplayed());
            Assert.assertTrue(successMessage.getText().contains("Thank you for your message. It has been sent."));
        }
    }

    @AfterTest
    public void tearDown() {
        // Close the browser window
        driver.quit();
    }


}
