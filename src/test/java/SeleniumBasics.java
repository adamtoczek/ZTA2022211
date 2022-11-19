import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumBasics extends BaseTest{
//    @Test
//    public void shouldFillForm() throws InterruptedException {
//        driver.get("http://146.59.32.4/index.php?controller=authentication&create_account=1");
//
//        driver.findElement(By.name("firstname")).sendKeys("Adam");
//
//
//        List<WebElement> radio =  driver.findElements(By.cssSelector(".radio-inline"));
//        for (WebElement r : radio) {
//            if (r.getText().equals("Mr."))
//                r.click();
//        }
//
//        driver.findElement(By.name("lastname")).sendKeys("Kwiatkowski");
//        driver.findElement(By.name("email")).sendKeys("test3@sii.pl");
//        driver.findElement(By.name("password")).sendKeys("12345");
//        driver.findElement(By.name("birthday")).sendKeys("01/01/1901");
//        driver.findElement(By.name("customer_privacy")).click();
//        driver.findElement(By.name("psgdpr")).click();
//
//        driver.findElement(By.cssSelector("#customer-form button[type='submit']")).click();
//        driver.findElement(By.linkText("Adam Kwiatkowski"));
//        Thread.sleep(5000);
//
//    }

    @Test
    public void dropDownTestIndex() throws InterruptedException {
        driver.get("https://automationtesting.co.uk/dropdown.html");
        Select cars = new Select(driver.findElement(By.id("cars")));

        cars.selectByIndex(3);
        Thread.sleep(1000);
    }

    @Test
    public void dropDownTestValue() throws InterruptedException {
        driver.get("https://automationtesting.co.uk/dropdown.html");
        Select cars = new Select(driver.findElement(By.id("cars")));

        cars.selectByValue("bmw");
        Thread.sleep(1000);


    }

    @Test
    public void dropDownTestVisibleText() throws InterruptedException {
        driver.get("https://automationtesting.co.uk/dropdown.html");
        Select cars = new Select(driver.findElement(By.id("cars")));

        cars.selectByVisibleText("Jeep");
        Thread.sleep(1000);
    }

    @Test
    public void addFileTest() throws InterruptedException {
        driver.get("https://automationtesting.co.uk/fileupload.html");
        WebElement fileInput = driver.findElement(By.cssSelector("#fileToUpload"));

        File f = new File("src\\main\\resources\\test.txt");
        fileInput.sendKeys(f.getAbsolutePath());
        Thread.sleep(3000);

        driver.findElement(By.name("submit")).click();
        Thread.sleep(3000);

    }

    @Test
    public void alertTest() throws InterruptedException {
        driver.get("https://automationtesting.co.uk/popups.html");
        driver.findElement(By.cssSelector("div.row:nth-of-type(2) button")).click();

        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        assertEquals("You have triggered the alert!", alertText);
        Thread.sleep(1000);
    }

    @Test
    public void iFrameTest() throws InterruptedException {
        driver.get("https://automationtesting.co.uk/iframes.html");

        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("a[href='#sidebar']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='popups.html']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("div.row:nth-of-type(2) button")).click();

        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        assertEquals("You have triggered the alert!", alertText);
        Thread.sleep(1000);

        driver.switchTo().defaultContent();

        assertEquals(2, driver.findElements(By.tagName("iframe")).size());
    }
}
