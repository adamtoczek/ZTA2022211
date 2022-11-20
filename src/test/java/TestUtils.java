import java.text.NumberFormat;
import java.util.Locale;

public class TestUtils {
    public static String formatPrice(double price) {
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(price);
    }
}
