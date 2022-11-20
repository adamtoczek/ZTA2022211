package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductCommons extends BasePage{
    private static final String CSS_QTY_FIELD = "#quantity_wanted";
    public static final String CSS_PRODUCT_VARIANTS = ".product-variants-item";
    public static final String CSS_VARIANT_LABEL = "span.control-label";
    private static final String CSS_ITEM_PRICE = ".current-price>span";
    public static final String CSS_ADD_TO_BASKET_BTN = "button.add-to-cart";

    protected String CSS_MODAL="";

    public void changeQty(int n) {
        WebElement qty =driver.findElement(By.cssSelector(getCSSSelector(CSS_QTY_FIELD)));
        qty.clear();
        qty.sendKeys(""+n);
    }

    public void changeOption(String option, String value) {
        String oldPrice = driver.findElement(By.cssSelector(getCSSSelector(CSS_ITEM_PRICE))).getAttribute("content");
        List<WebElement> variants = driver.findElements(By.cssSelector(getCSSSelector(CSS_PRODUCT_VARIANTS)));
        for (WebElement variant : variants) {
            if (variant.findElement(By.cssSelector(getCSSSelector(CSS_VARIANT_LABEL))).getText().trim().equals(option)) {
                Select options = new Select(variant.findElement(By.tagName("select")));
                if (!options.getFirstSelectedOption().getText().equals(value)) {
                    options.selectByVisibleText(value);
                    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
                    try {
                        wait.until(c -> !driver.findElement(By.cssSelector(getCSSSelector(CSS_ITEM_PRICE))).getAttribute("content").equals(oldPrice));
                    }
                    catch (TimeoutException e) {}
                }
                break;
            }
        }



    }
    public void addToBasket() {
        driver.findElement(By.cssSelector(getCSSSelector(CSS_ADD_TO_BASKET_BTN))).click();
        BasePage.cartPreview = new CartPreview();
    }

    public int getCurrentPrice() {
        return Integer.parseInt(driver.findElement(By.cssSelector(getCSSSelector(CSS_ITEM_PRICE))).getAttribute("content"));
    }

    private String getCSSSelector(String selector) {
        return CSS_MODAL + selector;
    }
}
