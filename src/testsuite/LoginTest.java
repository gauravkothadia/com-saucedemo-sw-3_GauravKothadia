package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        // * Enter “standard_user” username
        sendTextToElement(By.cssSelector("#user-name"), "standard_user");
        // * Enter “secret_sauce” password
        sendTextToElement(By.cssSelector("#password"), "secret_sauce");
        // * Click on ‘LOGIN’ button
        clickOnElement(By.cssSelector("#login-button"));
        // * Verify the text “PRODUCTS”
        Assert.assertEquals("Products", getTextFromElement(By.xpath("//div[@class='header_secondary_container']//span[@class='title']")));
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // * Enter “standard_user” username
        sendTextToElement(By.cssSelector("#user-name"), "standard_user");
        // * Enter “secret_sauce” password
        sendTextToElement(By.cssSelector("#password"), "secret_sauce");
        // * Click on ‘LOGIN’ button
        clickOnElement(By.cssSelector("#login-button"));
        // * Verify that six products are displayed on pag
        List<WebElement> listOfProductsDisplayed = findMultipleElements(By.xpath("//div[@class='inventory_item']"));
        Assert.assertTrue(listOfProductsDisplayed.size()==6);
    }

    @After
    public void tearDown() {
     //   closeBrowser();
    }
}
