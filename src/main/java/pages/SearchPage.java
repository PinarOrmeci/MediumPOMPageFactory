package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends BasePage
{
    public SearchPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
    }

    @FindBy(css="div.feature-discovery__big-circle")
    private WebElement bigCircle;

    @FindBy(id = "hideSearchFilter")
    private WebElement hideSearchFilter;

    @FindBy(id = "showSearchFilter")
    private WebElement showSearchFilter;

    @FindBy(className = "facetedFilteredLink")
    private List<WebElement> facetedFilteredLinks;

    public SearchPage closeBigCircle()
    {
        bigCircle.click();
        return this;
    }

    public SearchPage clickHideSearchFilter()
    {
        hideSearchFilter.click();
        return this;
    }

    public SearchPage clickShowSearchFilter()
    {
        showSearchFilter.click();
        return this;
    }

    public SearchPage waitSpinner()
    {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("opening")));
        return this;
    }

    public int getSizeFacetedFilteredLinks()
    {
        return facetedFilteredLinks.size();
    }
}
