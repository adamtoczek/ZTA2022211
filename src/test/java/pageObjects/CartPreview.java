package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPreview extends BasePage {

    public static final String CSS_PROCEED_BTN = ".cart-content-btn a";
    public static final String CSS_ITEM_PRICE = ".modal-body .product-price";
    public static final String CSS_SUBTOTAL_VALUE = ".subtotal.value";

    public CartPreview() {
        waitForModal();
    }

    public void waitForModal() {
        WebElement proceedBtn = driver.findElement(By.cssSelector(CSS_PROCEED_BTN));
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(proceedBtn));
    }

    public void clickProceedToCheckout() {
        driver.findElement(By.cssSelector(CSS_PROCEED_BTN)).click();
        BasePage.cartPage = new CartPage();
    }

    public String getItemPrice() {
        return driver.findElement(By.cssSelector(CSS_ITEM_PRICE)).getText();
    }

    public String getSubtotal() {
        return driver.findElement(By.cssSelector(CSS_SUBTOTAL_VALUE)).getText();
    }

}
