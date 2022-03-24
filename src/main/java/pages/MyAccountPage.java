package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage
{
    public MyAccountPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
    }

    @FindBy(id = "usernameArea")
    private WebElement usernameArea;

    public String getTextUserNameArea()
    {
        wait.until(ExpectedConditions.visibilityOf(usernameArea));
        return usernameArea.getText();
    }

}
