import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.BasePage;

import java.text.NumberFormat;
import java.time.Duration;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStorePOP extends BaseTest{
    @Test
    public void cartShouldContainAddedItems() throws InterruptedException {

        BasePage bp = new BasePage();
        bp.homePage.navigateTo();
        bp.homePage.openProduct("THE ADVENTURE POSTER");
        bp.productPage.changeOption("Dimension", "80x120cm");
        bp.productPage.changeQty(3);




        Select prodVariant = new Select(driver.findElement(By.cssSelector("div.product-variants select")));
        prodVariant.selectByValue("21");
        Thread.sleep(500);
        WebElement qty =driver.findElement(By.name("qty"));
        WebElement addQtyBtn = driver.findElement(By.cssSelector(".qty button:nth-of-type(1)"));
//        addQtyBtn.click();
//        addQtyBtn.click();
//        Actions actions = new Actions(driver);
//        actions.moveToElement(qty).doubleClick(qty).sendKeys("3").perform();
        qty.clear();
        qty.sendKeys(""+3);

        int curPrice = Integer.parseInt(driver.findElement(By.cssSelector(".current-price>span")).getAttribute("content"));
        String curPriceText = driver.findElement(By.cssSelector(".current-price>span")).getText();
        driver.findElement(By.cssSelector("button.add-to-cart")).click();
        WebElement proceedBtn = driver.findElement(By.cssSelector(".cart-content-btn a"));
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(proceedBtn));

        assertEquals(curPriceText, driver.findElement(By.cssSelector(".modal-body .product-price")).getText());

        String actualSubtotal = driver.findElement(By.cssSelector(".subtotal.value")).getText();
        double amount =curPrice*3;
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        currencyFormatter.format(amount);
        assertEquals(currencyFormatter.format(amount), actualSubtotal);

        proceedBtn.click();
        driver.findElement(By.cssSelector(".cart-container h1"));

        String actucalCartItemPrice =  driver.findElement(By.cssSelector("li.cart-item span.product-price")).getText();
        assertEquals(currencyFormatter.format(amount), actucalCartItemPrice);

        Thread.sleep(3000);

    }

}
