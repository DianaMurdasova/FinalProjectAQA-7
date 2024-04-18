package pages;
import constants.Url;
import functions.WaitersClass;
import functions.WorkWithElementClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AccountPage {
    public WebDriver driver;
    public WaitersClass waiters;
    public WorkWithElementClass workWithElement;



    public AccountPage(WebDriver driver) {
        this.driver = driver;
        waiters = new WaitersClass(driver);
        workWithElement = new WorkWithElementClass(driver);
        PageFactory.initElements(driver,this);
    }

    //сбор стринговых данных
    private static class Strings {
        private final static String correctEmail = "murdasova.diana4@gmail.com";
        private final static String correctPassword = "фьиук4дшіі";
        private final static String incorrectEmail = "murdasova@gmail.com";
    }

    // сбор локаторов
    @FindBy(xpath = "//span[@class='hidden-xs hidden-sm hidden-md']")
    private static WebElement personalAccountButton;
    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    private static WebElement rusLanguageButton;
    @FindBy(xpath = "//a[text()='Регистрация']")
    private static WebElement registerButton;
    @FindBy(xpath = "//a[text()='Авторизация']")
    private static WebElement authorizationButton;
    @FindBy(xpath = "//input[@placeholder='E-Mail']")
    private static WebElement authorizationEmailField;
    @FindBy(xpath = "//input[@type='password']")
    private static WebElement authorizationPasswordField;
    @FindBy(xpath = "//button[text()='Войти']")
    private static WebElement authorizationEnterButton;
    @FindBy(xpath = "//div[@class='text-danger']")
    private static WebElement authorizationFailedMessage;
    @FindBy(xpath = "//i[@class='fa fa-clock-o']")
    private static WebElement orderHistoryButton;
    @FindBy(xpath = "//a[text()='Выход']")
    private static WebElement logoutButton;
    @FindBy(xpath = "//a[@class='oct-button current-link']")
    private static WebElement continueLogoutButton;
    @FindBy(xpath = "//a[text()='Забыли пароль']")
    private static WebElement forgotPasswordButton;
    @FindBy(xpath = "//input[@id='input-email']")
    private static WebElement forgotPasswordEmailField;
    @FindBy(xpath = "//td[text()='№ Заказа']")
    private static WebElement orderNumberColumnText;


    //Открытие главной страницы
    public AccountPage openMainPage() {
        driver.get(Url.DRSMOKE_HOME_PAGE);
        return this;
    }

    //Выбор языка сайта на всплывающем окне
    public AccountPage chooseRusLanguageOnModalWindow() {
        waiters.waitForVisibilityOfWebElement(rusLanguageButton);
        rusLanguageButton.click();
        return this;
    }

    //Открытие страницы Личный кабинет
    public AccountPage openPersonalAccountPage() {
        driver.get(Url.DRSMOKE_PERSONAL_ACCOUNT_PAGE);
        return this;
    }

    //выбор пункта Авторизация в выпадающем списке Личный кабинет
    public AccountPage selectAuthorizationButton(){
        personalAccountButton.click();
        waiters.waitForVisibilityOfWebElement(authorizationButton);
        authorizationButton.click();
        return this;
    }
    //Ввод правильного имейла
    public AccountPage setValidEmail() {
        waiters.waitForVisibilityOfWebElement(authorizationEmailField);
        authorizationEmailField.sendKeys(Strings.correctEmail);
        //logger.info("Trying to send valid mail to field " + email.toString());
        return this;
    }

    //Ввод правильного пароля
    public AccountPage setValidPassword() {
        waiters.waitForVisibilityOfWebElement(authorizationPasswordField);
        authorizationPasswordField.sendKeys(Strings.correctPassword);
        //logger.info("Trying to send valid mail to field " + email.toString());
        return this;
    }
    //Ввод неправильного имейла
    public AccountPage setInvalidEmail() {
        waiters.waitForVisibilityOfWebElement(authorizationEmailField);
        authorizationEmailField.sendKeys(Strings.incorrectEmail);
        //logger.info("Trying to send valid mail to field " + email.toString());
        return this;
    }

    //Нажатие на кнопку Войти в окне авторизации
    public AccountPage clickOnAuthorizationEnterButton(){
        authorizationEnterButton.click();
        return this;
    }

    //Подвердить видимость сообщения о неуспешном входе в аккаунт
    public AccountPage visibilityOfUnsuccessfulLoginMessage(){
        waiters.waitForVisibilityOfWebElement(authorizationFailedMessage);
        authorizationFailedMessage.isDisplayed();
        return this;
    }


    //Нажатие на кнопку Забыли пароль в окне авторизации
    public AccountPage clickOnForgotPasswordButton(){
        waiters.waitForVisibilityOfWebElement(forgotPasswordButton);
        forgotPasswordButton.click();
        return this;
    }

    //Проверить наличие поля для ввода email на странице Забыли пароль
    public AccountPage visibilityOfEmailFieldOnForgotPasswordPage(){
        forgotPasswordEmailField.isDisplayed();
        return this;
    }

    //Нажатие на кнопку История заказов в Личном кабинете
    public AccountPage clickOnOrderHistoryButton(){
        orderHistoryButton.click();
        return this;
    }

    //Подвердить видимость названия колонки № Заказа
    public AccountPage visibilityOfOrderNumberColumnText(){
        orderNumberColumnText.isDisplayed();
        return this;
    }

    //Нажатие на кнопку Выход в верхнем меню
    public AccountPage clickOnLogoutButtonFromMenu(){
        personalAccountButton.click();
        waiters.waitForVisibilityOfWebElement(logoutButton);
        logoutButton.click();
        return this;
    }

    //Нажатие на кнопку Подтвердить для выхода из личного кабинета
    public AccountPage clickOnContinueLogoutButton(){
        waiters.waitForVisibilityOfWebElement(continueLogoutButton);
        continueLogoutButton.click();
        return this;
    }

}
