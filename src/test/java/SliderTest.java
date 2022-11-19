import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SliderTest extends BaseTest{
    @Test
    public void sliderTest1() throws InterruptedException {
        driver.get("https://www.w3schools.com/howto/howto_js_rangeslider.asp");
        WebElement slider = driver.findElement(By.id("id2"));
        int pos = Integer.parseInt(slider.getAttribute("value"));

        for (int i = pos; i>30; i--) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }

        Thread.sleep(5000);
    }

    @Test
    public void sliderTest2() throws InterruptedException {
        driver.get("https://www.w3schools.com/howto/howto_js_rangeslider.asp");
        WebElement slider = driver.findElement(By.id("id2"));

        moveSlider(slider, 60);
        moveSlider(slider, 30);
        moveSlider(slider, 30);
        moveSlider(slider, 20);
        moveSlider(slider, 70);

        Thread.sleep(5000);
    }

    private void moveSlider(WebElement slider, int newPos) {
        int delta = Integer.parseInt(slider.getAttribute("value")) - newPos;
        Keys arrow;
        if (delta==0)
            return;
        if (delta > 0)
            arrow = Keys.ARROW_LEFT;
        else
            arrow = Keys.ARROW_RIGHT;

        for (int i = 0; i<Math.abs(delta); i++) {
            slider.sendKeys(arrow);
        }
    }


}
