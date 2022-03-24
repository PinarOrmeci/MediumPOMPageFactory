import org.junit.jupiter.api.Test;
import pages.SearchPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest extends BaseTest
{
    SearchPage searchPage;

    @Test
    public void testShowHideSearchFilter()
    {
        searchPage = goToUrl(new SearchPage(driver, wait), "https://www.sahibinden.com//emlak?query_text=istanbul")
                .closeBigCircle()
                .clickHideSearchFilter()
                .clickShowSearchFilter()
                .waitSpinner();

        assertTrue(searchPage.getSizeFacetedFilteredLinks() > 0);
    }
}
