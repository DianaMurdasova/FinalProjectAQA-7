import driver.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ProductPage;
import utils.MyAllureListener;

@Listeners({MyAllureListener.class})
public class ProductPageTest {
    static final Logger logger = LoggerFactory.getLogger(ProductPageTest.class);
    protected WebDriver driver;
    protected ProductPage productPage;

    @BeforeClass
    public void setUp(){
        driver = DriverSetUp.startDriver();
        productPage = new ProductPage(driver);
    }
    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test(priority = 1)
    public void openProductCardByClickingOnProductImage(){
        productPage
                .openMainPage()
                .chooseRusLanguageOnModalWindow()
                .selectAuthorizationButton()
                .setValidEmail()
                .setValidPassword()
                .clickOnAuthorizationEnterButton()
                .openMainPage()
                .sendTextInSearchField()
                .clickOnSearchButton()
                .clickOnProductCard();
        logger.info("The open product card by clicking on product image is working correctly!");
    }

    @Test(priority = 2)
    public void addProductToCartWithSelectedColor(){
        productPage
                .openMainPage()
                .sendTextInSearchField()
                .clickOnSearchButton()
                .clickOnProductCard()
                .clickOnTigerColor()
                .clickOnAddToCartButton()
                .visibilityOfCartWindow();
        logger.info("Add product to cart with selected color is working correctly!");
    }

    @Test(priority = 3)
    public void addProductToCartWithoutSelectedColor(){
        productPage
                .openMainPage()
                .sendTextInSearchField()
                .clickOnSearchButton()
                .clickOnProductCard()
                .clickOnAddToCartButton()
                .visibilityOfAlertMessage();
        logger.info("Add product to cart without selected color is working correctly!");
    }

    @Test(priority = 4)
    public void addProductToWishlist() {
        productPage
                .openMainPage()
                .sendTextInSearchField()
                .clickOnSearchButton()
                .clickOnProductCard()
                .clickOnAddToWishlistButton()
                .visibilityOfAddedToWishlistWindow();
        logger.info("Add product to wishlist is working correctly!");
    }

    @Test(priority = 5)
    public void addProductToCompare() {
        productPage
                .openMainPage()
                .sendTextInSearchField()
                .clickOnSearchButton()
                .clickOnProductCard()
                .clickOnAddToCompareButton()
                .visibilityOfAddedToCompareWindow();
        logger.info("Add product to compare is working correctly!");
    }


}
