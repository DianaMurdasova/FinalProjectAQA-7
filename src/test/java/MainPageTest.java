import driver.DriverSetUp;
import functions.WaitersClass;
import functions.WorkWithElementClass;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.MyAllureListener;

@Listeners({MyAllureListener.class})
public class MainPageTest {
    static final Logger logger = LoggerFactory.getLogger(MainPageTest.class);
    protected WebDriver driver;
    protected MainPage mainPage = new MainPage(driver);
    protected WaitersClass waiters= new WaitersClass(driver);
    protected WorkWithElementClass workWithElement = new WorkWithElementClass(driver);


    @BeforeClass
    public void setUp(){
        driver = DriverSetUp.startDriver();
        mainPage = new MainPage(driver);
    }
    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test
    @Description("1")
    public void openMainPageCorrect(){
        mainPage.openMainPage().chooseRusLanguageOnModalWindow().waitForVisibilityOfWelcomeString();
        logger.info("The main page is open correctly!");
    }

//    @Test
//    @Description
//    public void checkingSearchFieldWorkingCorrect(){}
//
//    @Test
//    @Description
//    public void switchToRegistrationPage(){}
//
//    @Test
//    @Description
//    public void switchToShippingAndPaymentPage(){}
//
//    @Test
//    @Description
//    public void availabilityOfProductCategoryNames(){}


}
