import driver.DriverSetUp;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import pages.MainPage;
import utils.MyAllureListener;

@Listeners({MyAllureListener.class})
public class MainPageTest {
    static final Logger logger = LoggerFactory.getLogger(MainPageTest.class);
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeClass
    public void setUp(){
        driver = DriverSetUp.startDriver();
        mainPage = new MainPage(driver);
    }
    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test(priority = 1)
    public void openMainPageCorrect(){
        mainPage
                .openMainPage()
                .chooseRusLanguageOnModalWindow()
                .visibilityOfWelcomeString();
        logger.info("The main page is open correctly!");
    }

    @Test(priority = 2)
    public void checkingSearchFieldWorkingCorrect(){
    mainPage
            .openMainPage()
            .sendTextInSearchField()
            .clickOnSearchButton()
            .checkingSearchHeaderCorrectVisibility();
        logger.info("The search field is working correctly!");
    }

    @Test(priority = 3)
    public void switchToRegistrationPage(){
        mainPage
                .openMainPage()
                .selectRegistrationButton()
                .checkingEnabledFieldConfirmPassword();
        logger.info("The registration page is open correctly!");
    }

    @Test(priority = 4)
    public void switchToShippingAndPaymentPage(){
        mainPage
                .openMainPage()
                .openDeliveryAndPaymentPage()
                .visibilityOfDeliveryAndPaymentHeaders();
        logger.info("Delivery and Payment page is open correctly!");
    }

    @Test(priority = 5)
    public void switchSiteLanguageToUkr(){
        mainPage
                .openMainPage()
                .ifThereIsRusTextInTitle()
                .clickUkrLanguageButton()
                .ifThereIsUkrTextInTitle();
        logger.info("The page language is Ukrainian!");
    }

}
