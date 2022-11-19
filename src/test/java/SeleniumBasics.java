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


        Thread.sleep(5000);

    }
}
