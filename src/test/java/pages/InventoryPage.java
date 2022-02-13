package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    public WebDriver driver;
    public InventoryPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "item_4_title_link")
    public WebElement viewSauceLabsBackpack;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addSauceLabsBackpack;

    @FindBy(id = "item_0_title_link")
    public WebElement viewSauceLabsBikeLight;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    public WebElement addSauceLabsBikeLight;

    @FindBy(id = "item_1_title_link")
    public WebElement viewSauceLabsBoltTshirt;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    public WebElement addSauceLabsBoltTshirt;

    @FindBy(id = "item_5_title_link")
    public WebElement viewSauceLabsFleeceJacket;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement addSauceLabsFleeceJacket;

    @FindBy(id = "back-to-products")
    public WebElement backToProducts;

    @FindBy(id = "shopping_cart_container")
    public WebElement basketButton;

    @FindBy(id = "checkout")
    public WebElement checkoutButton;

    public void addCart(WebElement viewCart, WebElement addCart){
        viewCart.click();
        addCart.click();
        backToProducts.click();

    }

    public void addAllCart(WebElement[][] elements) {

        for (int i=0; i<elements.length; i++)
        {
            addCart(elements [i][0], elements [i][1]);
        }

    }
































}
