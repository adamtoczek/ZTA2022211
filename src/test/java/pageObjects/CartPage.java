package pageObjects;

import org.openqa.selenium.By;

public class CartPage extends BasePage{

    public static final String CSS_CART_PAGE_TITLE = ".cart-container h1";

    public CartPage() {
        driver.findElement(By.cssSelector(CSS_CART_PAGE_TITLE));
    }

    public String getItemPrice() {
        return driver.findElement(By.cssSelector("li.cart-item span.product-price")).getText();
    }
}
