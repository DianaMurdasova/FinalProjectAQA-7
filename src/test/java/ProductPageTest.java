import driver.DriverSetUp;
import functions.WaitersClass;
import functions.WorkWithElementClass;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.AccountPage;
import utils.MyAllureListener;

@Listeners({MyAllureListener.class})
public class ProductPageTest {
    static final Logger logger = LoggerFactory.getLogger(ProductPageTest.class);
    protected WebDriver driver;
    protected AccountPage accountPage = new AccountPage(driver);
    protected WaitersClass waiters= new WaitersClass(driver);
    protected WorkWithElementClass workWithElement = new WorkWithElementClass(driver);

    @BeforeClass
    public void setUp(){
        driver = DriverSetUp.startDriver();
        accountPage = new AccountPage(driver);
    }
    @AfterClass
    public void stop(){
        driver.quit();
    }

    @Test(priority = 1)
    public void incorrectLoginToPersonalAccount(){
        accountPage
                .openMainPage()
                .chooseRusLanguageOnModalWindow()
                .selectAuthorizationButton()
                .setInvalidEmail()
                .setValidPassword()
                .clickOnAuthorizationEnterButton();
        logger.info("The unsuccessful login message is working correctly!");
    }


    @Test(priority = 2)
    public void checkingWorkOfForgotPasswordButton(){
        accountPage
                .openMainPage()
                .selectAuthorizationButton()
                .clickOnForgotPasswordButton()
                .visibilityOfEmailFieldOnForgotPasswordPage();
        logger.info("The Forgot password button is working correctly!");
    }

    @Test(priority = 3)
    public void correctLoginToPersonalAccount(){
        accountPage
                .openMainPage()
                .selectAuthorizationButton()
                .setValidEmail()
                .setValidPassword()
                .clickOnAuthorizationEnterButton();
        logger.info("The login is working correctly!");
    }

    @Test(priority = 4)
    public void checkingWorkOfOrderHistoryButton(){
        accountPage
                .openPersonalAccountPage()
                .clickOnOrderHistoryButton()
                .visibilityOfOrderNumberColumnText();
        logger.info("The Order History button is working correctly!");
    }


    @Test(priority = 5)
    public void correctLogoutFromPersonalAccountFromMainPage(){
        accountPage
                .openMainPage()
                .clickOnLogoutButtonFromMenu()
                .clickOnContinueLogoutButton();
        logger.info("The logout is working correctly!");
    }


}
