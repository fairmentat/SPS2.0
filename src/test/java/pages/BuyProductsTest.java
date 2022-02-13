package pages;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BuyProductsTest {

    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static InventoryPage inventoryPage;
    public static CheckoutPage checkoutPage;


    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(ConfProperties.getProperty("loginpage"));

        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        checkoutPage = new CheckoutPage(driver);
        inventoryPage = new InventoryPage(driver);


    }

    @Test
    public void BuyProductsTest(){

        loginPage.inputlogin(ConfProperties.getProperty("login"), ConfProperties.getProperty("password") );

        WebElement[][] addElements = {{inventoryPage.viewSauceLabsBackpack, inventoryPage.addSauceLabsBackpack},
                {inventoryPage.viewSauceLabsBoltTshirt, inventoryPage.addSauceLabsBoltTshirt},
                {inventoryPage.viewSauceLabsFleeceJacket, inventoryPage.addSauceLabsFleeceJacket}};

        inventoryPage.addAllCart(addElements);

        inventoryPage.basketButton.click();

        inventoryPage.checkoutButton.click();

        checkoutPage.addDataUser(ConfProperties.getProperty("firstName"), ConfProperties.getProperty("lastName"),
                ConfProperties.getProperty("zipCode"));

        checkoutPage.finishButton.click();

        Assert.assertEquals(ConfProperties.getProperty("checkoutComplete"), checkoutPage.checkoutMessage.getText());

        checkoutPage.backToProductsButton.click();

    }

    @AfterClass

    public static void exit() {

        profilePage.entryMenu();
        profilePage.userLogout();
        //driver.quit();

    }






}
