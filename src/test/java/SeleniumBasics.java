import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
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

    @Test
    public void tableTest(){
        driver.get("https://automationtesting.co.uk/tables.html");

        int counter = 0;

        List<WebElement> rows = driver.findElements(By.cssSelector("tbody tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (cells.get(4).getText().equals("United Kingdom")) {
                System.out.println(cells.get(0).getText() + " " + cells.get(1).getText());
                counter++;
            }
        }
        assertEquals(2, counter);
    }

    @Test
    public void dragTest1() throws InterruptedException {
        driver.get("https://automationtesting.co.uk/actions.html");
        Actions actions = new Actions(driver);
        WebElement obj = driver.findElement(By.cssSelector("#dragtarget"));
        WebElement target = driver.findElement(By.cssSelector(".droptarget:nth-of-type(2)"));
        System.out.println("target text " + target.getText());

        //actions.dragAndDrop(obj, target).build().perform();
//        actions.clickAndHold(obj).moveToElement(target).release().perform();
//        actions.clickAndHold(obj).moveByOffset(200,0).release().perform();
        actions.moveToElement(obj).moveByOffset(3, 3). clickAndHold().moveToElement(target).release().perform();
        Thread.sleep(1000);
        assertEquals("Drag me!", target.getText());
    }

    @Test
    public void dragTest2() throws InterruptedException {
        driver.get("https://www.w3schools.com/howto/howto_js_draggable.asp");
        WebElement source = driver.findElement(By.cssSelector("#mydivheader"));
        Actions actios = new Actions(driver);
        actios.clickAndHold(source).moveByOffset(500,0).release().perform();

        Thread.sleep(5000);
    }

    @Test
    public void actionsTest() throws InterruptedException {
        driver.get("https://automationtesting.co.uk/actions.html");
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("holdDown"));
        actions.clickAndHold(element).perform();
        Thread.sleep(1000);


        WebElement dbClick = driver.findElement(By.id("doubClickStartText"));
        actions.doubleClick(dbClick).perform();
        assertEquals("Well Done!", dbClick.getText().trim());
    }

    @Test
    public void explicitWaitTest() throws InterruptedException {
        driver.get("https://automationtesting.co.uk/loader.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loaderBtn")));
        btn.click();

    }

    @Test
    public void explicitWaitMenuTest() throws InterruptedException {
        driver.get("https://automationtesting.co.uk/index.html");
        WebElement sidebarBtn = driver.findElement(By.cssSelector("#sidebar>a"));
        sidebarBtn.click();
        Thread.sleep(1000);
        sidebarBtn.click();
        driver.findElement(By.cssSelector("#sidebar li a")).click();

    }

}
