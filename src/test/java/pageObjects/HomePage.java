package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage{
    private static final String URL_HOME_PAGE = "http://146.59.32.4/index.php";
    private static final String CSS_PRODUCT_NAMES = ".h3.product-title";

    public static void navigateTo(){
        driver.get(homePage.URL_HOME_PAGE);
        BasePage.homePage = new HomePage();
    }


    public void openProduct(String productName) {
        List<WebElement> tiles =  driver.findElements(By.cssSelector(CSS_PRODUCT_NAMES));

        for (WebElement tile : tiles) {
            if (tile.getText().trim().equals(productName)) {
                tile.click();
                break;
            }
        }
    }
}
