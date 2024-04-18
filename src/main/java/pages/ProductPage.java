package pages;
import constants.Url;
import functions.WaitersClass;
import functions.WorkWithElementClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public WebDriver driver;
    public WaitersClass waiters;
    public WorkWithElementClass workWithElement;



    public ProductPage(WebDriver driver) {
        this.driver = driver;
        waiters = new WaitersClass(driver);
        workWithElement = new WorkWithElementClass(driver);
        PageFactory.initElements(driver,this);
    }

    //сбор стринговых данных
    private static class Strings {
        private final static String correctEmail = "murdasova.diana4@gmail.com";
        private final static String correctPassword = "фьиук4дшіі";

    }

    // сбор локаторов
    @FindBy(xpath = "//span[@class='hidden-xs hidden-sm hidden-md']")
    private static WebElement personalAccountButton;
    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    private static WebElement rusLanguageButton;
    @FindBy(xpath = "//a[text()='Авторизация']")
    private static WebElement authorizationButton;
    @FindBy(xpath = "//input[@placeholder='E-Mail']")
    private static WebElement authorizationEmailField;
    @FindBy(xpath = "//input[@type='password']")
    private static WebElement authorizationPasswordField;
    @FindBy(xpath = "//button[text()='Войти']")
    private static WebElement authorizationEnterButton;



    //Открытие главной страницы
    public ProductPage openMainPage() {
        driver.get(Url.DRSMOKE_HOME_PAGE);
        return this;
    }

    //Выбор языка сайта на всплывающем окне
    public ProductPage chooseRusLanguageOnModalWindow() {
        waiters.waitForVisibilityOfWebElement(rusLanguageButton);
        rusLanguageButton.click();
        return this;
    }

    //Открытие страницы POD устройства
    public ProductPage openPodSystemsPage() {
        driver.get(Url.DRSMOKE_POD_SYSTEMY_PAGE);
        return this;
    }

    //выбор пункта Авторизация в выпадающем списке Личный кабинет
    public ProductPage selectAuthorizationButton(){
        personalAccountButton.click();
        waiters.waitForVisibilityOfWebElement(authorizationButton);
        authorizationButton.click();
        return this;
    }
    //Ввод правильного имейла
    public ProductPage setValidEmail() {
        waiters.waitForVisibilityOfWebElement(authorizationEmailField);
        authorizationEmailField.sendKeys(Strings.correctEmail);
        //logger.info("Trying to send valid mail to field " + email.toString());
        return this;
    }

    //Ввод правильного пароля
    public ProductPage setValidPassword() {
        waiters.waitForVisibilityOfWebElement(authorizationPasswordField);
        authorizationPasswordField.sendKeys(Strings.correctPassword);
        //logger.info("Trying to send valid mail to field " + email.toString());
        return this;
    }

    //Нажатие на кнопку Войти в окне авторизации
    public ProductPage clickOnAuthorizationEnterButton(){
        authorizationEnterButton.click();
        return this;
    }




    //
    //
    //


}
