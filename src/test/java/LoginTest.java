import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MyAccountPage;

import static util.Constants.*;

public class LoginTest extends BaseTest
{
    LoginPage loginPage;

    @BeforeEach
    public void before()
    {
        super.before();
        loginPage = goToUrl(new LoginPage(driver, wait), "https://secure.sahibinden.com/giris");
    }

    @Description("Boş kullanıcı adı/boş şifre ile uyarı mesajı")
    @Test
    public void testEmptyInfoLogin()
    {
        loginPage.login(loginPage, "username", "password");
        Assertions.assertAll(
                () -> Assertions.assertTrue(loginPage.isDisplayedEmptyUserNameError()),
                () -> Assertions.assertEquals(ERROR_TEXT, loginPage.getTextEmptyUserNameError())
        );
    }

    @Description("Başarılı login")
    @Test
    public void testSuccessfulLogin()
    {
        MyAccountPage myAccountPage = loginPage.login(new MyAccountPage(driver, wait), "rightUsername", "rightPassword");
        Assertions.assertEquals(USERNAME, myAccountPage.getTextUserNameArea());
        Assertions.assertEquals("https://banaozel.sahibinden.com/",driver.getCurrentUrl());
    }
}
