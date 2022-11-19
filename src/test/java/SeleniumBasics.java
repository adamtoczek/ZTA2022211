import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumBasics extends BaseTest{
    @Test
    public void shouldFillForm() throws InterruptedException {
        driver.get("http://146.59.32.4/index.php?controller=authentication&create_account=1");

        driver.findElement(By.name("firstname")).sendKeys("Adam");


        List<WebElement> radio =  driver.findElements(By.cssSelector(".radio-inline"));
        for (WebElement r : radio) {
            if (r.getText().equals("Mr."))
                r.click();
        }

        driver.findElement(By.name("lastname")).sendKeys("Kwiatkowski");
        driver.findElement(By.name("email")).sendKeys("test3@sii.pl");
        driver.findElement(By.name("password")).sendKeys("12345");
        driver.findElement(By.name("birthday")).sendKeys("01/01/1901");
        driver.findElement(By.name("customer_privacy")).click();
        driver.findElement(By.name("psgdpr")).click();

        driver.findElement(By.cssSelector("#customer-form button[type='submit']")).click();
        driver.findElement(By.linkText("Adam Kwiatkowski"));
        Thread.sleep(5000);

    }
}
