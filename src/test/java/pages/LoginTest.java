package pages;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;



public class LoginTest {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;

    public static WebDriver driver;



    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(ConfProperties.getProperty("loginpage"));

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);


    }

    @Test
    public void loginTest(){

        loginPage.inputlogin(ConfProperties.getProperty("login"), ConfProperties.getProperty("password") );
        String element = profilePage.getLoginValid();

        Assert.assertEquals(ConfProperties.getProperty("equalTest"), element);

    }

    @AfterClass

    public static void exit() {

        profilePage.entryMenu();
        profilePage.userLogout();
        //driver.quit();

    }



}
