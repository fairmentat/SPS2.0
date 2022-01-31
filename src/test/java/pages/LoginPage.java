package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(id = "user-name")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void inputlogin(String login, String pass){
        loginField.sendKeys(login);
        passField.sendKeys(pass);
        loginButton.click();

    }













}
