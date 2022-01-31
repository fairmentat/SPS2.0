package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    public WebDriver driver;
    public ProfilePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    private WebElement validEnter;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logOut;



    public String getLoginValid() {
        String logElement = validEnter.getText();
        return logElement;
    }

    public void entryMenu() {
        burgerMenuButton.click();
    }

    public void userLogout() {
        logOut.click();

    }
}
























