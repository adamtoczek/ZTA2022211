package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage extends BasePage{
    private static final String NAME_QTY_FIELD = "qty";
    public static final String CSS_PRODUCT_VARIANTS = ".product-variants-item";
    public static final String CSS_VARIANT_LABEL = "span.control-label";
    private static final String CSS_ITEM_PRICE = ".current-price>span";

    public void changeQty(int n) {
        WebElement qty =driver.findElement(By.name(NAME_QTY_FIELD));
        qty.clear();
        qty.sendKeys(""+n);
    }

    public void changeOption(String option, String value) throws InterruptedException {
        String oldPrice = driver.findElement(By.cssSelector(CSS_ITEM_PRICE)).getAttribute("content");
        List<WebElement> variants = driver.findElements(By.cssSelector(CSS_PRODUCT_VARIANTS));
        for (WebElement variant : variants) {
            if (variant.findElement(By.cssSelector(CSS_VARIANT_LABEL)).getText().trim().equals(option)) {
                Select options = new Select(variant.findElement(By.tagName("select")));
                if (!options.getFirstSelectedOption().getText().equals(value)) {
                    options.selectByVisibleText(value);
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
                    wait.until(c -> !driver.findElement(By.cssSelector(CSS_ITEM_PRICE)).getAttribute("content").equals(oldPrice));
                }
                break;
            }
        }



    }
}
