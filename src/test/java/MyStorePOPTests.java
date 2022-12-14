import org.junit.jupiter.api.Test;
import pageObjects.BasePage;
import pageObjects.HomePage;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStorePOPTests extends BaseTest{
    @Test
    public void cartShouldContainAddedItems() throws InterruptedException {
        int qty = 3;

        BasePage bp = new BasePage();
        HomePage.navigateTo();
        BasePage.homePage.openProduct("THE ADVENTURE POSTER");
        BasePage.productPage.changeOption("Dimension", "80x120cm");
        BasePage.productPage.changeQty(qty);
        BasePage.productPage.addToBasket();

        int curPrice = BasePage.productPage.getCurrentPrice();
        assertEquals(TestUtils.formatPrice(curPrice), BasePage.cartPreview.getItemPrice());
        assertEquals(TestUtils.formatPrice(curPrice*qty), BasePage.cartPreview.getSubtotal());

        BasePage.cartPreview.clickProceedToCheckout();

        assertEquals(TestUtils.formatPrice(curPrice*qty), BasePage.cartPage.getItemPrice());

        bp.searchFor("hummingbird");
        assertEquals(5, BasePage.resultsPage.getResultsCount());
        BasePage.resultsPage.clickQuickView("HUMMINGBIRD T-SHIRT");
        BasePage.productQuickView.changeOption("Size", "M").changeOption("Color", "Black").changeQty(2).addToBasket();
        BasePage.cartPreview.clickProceedToCheckout();


        Thread.sleep(5000);

    }

}
