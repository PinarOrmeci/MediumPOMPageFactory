import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static util.Constants.ERROR_TEXT;

public class TestWithOutPom
{
    private WebDriver driver;

    @BeforeEach
    public void before(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://secure.sahibinden.com/giris");
    }

    @Description("Boş kullanıcı adı/boş şifre ile uyarı mesajı")
    @Test
    public void testEmptyInfoLogin(){
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("");

        WebElement submitBtn = driver.findElement(By.id("userLoginSubmitButton"));
        submitBtn.click();

        WebElement emptyUserNameError = driver.findElement(By.cssSelector("#username +label"));
        Assertions.assertTrue(emptyUserNameError.isDisplayed());
        Assertions.assertEquals(ERROR_TEXT,emptyUserNameError.getText());
    }

    @Description("Başarılı login")
    @Test
    public void testSuccessfulLogin(){
        driver.get("https://sahibinden.com");
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("username");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("password");

        WebElement submitBtn = driver.findElement(By.id("userLoginSubmitButton"));
        submitBtn.click();

        WebElement emptyUserNameError = driver.findElement(By.cssSelector("#username +label"));
        Assertions.assertFalse(emptyUserNameError.isDisplayed());
    }

    @AfterEach
    public void after(){
        driver.quit();
    }
}
