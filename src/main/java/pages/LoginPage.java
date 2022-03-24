package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage
{

    public LoginPage(WebDriver driver, WebDriverWait wait)
    {
        super(driver, wait);
    }

    @FindBy(id = "username")
    private WebElement usernameTextBox;

    @FindBy(id = "password")
    private WebElement passwordTextBox;

    @FindBy(id = "userLoginSubmitButton")
    private WebElement submitBtn;

    @FindBy(css = "#username +label")
    private WebElement emptyUserNameError;

    public <T extends BasePage> T login(T page, String username, String password)
    {
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        submitBtn.click();
        return page;
    }

    public String getTextEmptyUserNameError()
    {
        return emptyUserNameError.getText();
    }

    public boolean isDisplayedEmptyUserNameError()
    {
        return emptyUserNameError.isDisplayed();
    }
}
