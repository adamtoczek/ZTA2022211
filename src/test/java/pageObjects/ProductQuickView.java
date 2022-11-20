package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductQuickView extends ProductCommons{

    public ProductQuickView() {
        waitForModal();
        CSS_MODAL=".modal-body ";
    }

    public void waitForModal() {
        WebElement addToCartBtn = driver.findElement(By.cssSelector(CSS_ADD_TO_BASKET_BTN));
        Wait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
    }



}
