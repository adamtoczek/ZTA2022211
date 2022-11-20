package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class ResultsPage extends BasePage{

    public static final String CSS_PRODUCT_TILE = "article";
    private static final String CSS_PRODUCT_NAMES = ".h3.product-title";
    public static final String CSS_QUICK_VIEW_A = "a.quick-view";

    public int getResultsCount() {
        return driver.findElements(By.cssSelector(CSS_PRODUCT_TILE)).size();
    }

    public void clickQuickView(String productName) {
        List<WebElement> tiles = driver.findElements(By.cssSelector(CSS_PRODUCT_TILE));
        for (WebElement tile : tiles) {
            if (tile.findElement(By.cssSelector(CSS_PRODUCT_NAMES)).getText().trim().equals(productName)) {
                WebElement a = tile.findElement(By.cssSelector(CSS_QUICK_VIEW_A));
                Actions actions = new Actions(driver);
                actions.moveToElement(a).perform();
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
                wait.until(ExpectedConditions.visibilityOf(a));
                a.click();
                break;
            }
        }

    }
}
