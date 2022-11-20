package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


public class BasePage {
    public static WebDriver driver;

    public static HomePage homePage;
    public static ProductPage productPage;
    public static CartPreview cartPreview;
    public static CartPage cartPage;
    public static ResultsPage resultsPage;
    public static ProductQuickView productQuickView;

    public void searchFor(String text) {
        driver.findElement(By.name("s")).sendKeys(text + Keys.ENTER);
        resultsPage = new ResultsPage();
    }
}
