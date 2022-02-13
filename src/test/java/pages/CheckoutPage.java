package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    public WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
    public WebElement checkoutMessage;

    @FindBy(id = "back-to-products")
    public WebElement backToProductsButton;

    public void addDataUser(String name, String lastName, String zipCode){
        firstNameField.sendKeys(name);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(zipCode);
        continueButton.click();

    }

}
