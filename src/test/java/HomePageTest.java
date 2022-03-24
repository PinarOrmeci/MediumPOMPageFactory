import org.junit.jupiter.api.Test;
import pages.HomePage;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest extends BaseTest
{
    HomePage homePage;

    @Test
    public void testHomePageCopyRight()
    {
        homePage = goToUrl(new HomePage(driver, wait), "https://www.sahibinden.com/");
        Calendar calendar = Calendar.getInstance();
        String currentYear = Integer.toString(calendar.get(Calendar.YEAR));
        String copyRightActual = "Copyright © 2000-" + currentYear + " sahibinden.com";
        assertEquals(copyRightActual, homePage.getTextCopyRightInfo());
    }
}
