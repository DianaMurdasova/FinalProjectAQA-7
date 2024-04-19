package pages;
import constants.Url;
import functions.WaitersClass;
import functions.WorkWithElementClass;
import io.qameta.allure.Step;
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
    @Step("Clicking the Search button")
    public AccountPage openMainPage() {
        driver.get(Url.DRSMOKE_HOME_PAGE);
        return this;
    }

    //Выбор языка сайта на всплывающем окне
    @Step("Clicking the Search button")
    public AccountPage chooseRusLanguageOnModalWindow() {
        waiters.waitForVisibilityOfWebElement(rusLanguageButton);
        rusLanguageButton.click();
        return this;
    }

    //Открытие страницы Личный кабинет
    @Step("Clicking the Search button")
    public AccountPage openPersonalAccountPage() {
        driver.get(Url.DRSMOKE_PERSONAL_ACCOUNT_PAGE);
        return this;
    }

    //Выбор пункта Авторизация в выпадающем списке Личный кабинет
    @Step("Selecting the Authorization item in the Personal Account drop-down list")
    public AccountPage selectAuthorizationButton(){
        personalAccountButton.click();
        waiters.waitForVisibilityOfWebElement(authorizationButton);
        authorizationButton.click();
        return this;
    }
    //Ввод правильного имейла
    @Step("Entering the correct email")
    public AccountPage setValidEmail() {
        waiters.waitForVisibilityOfWebElement(authorizationEmailField);
        authorizationEmailField.sendKeys(Strings.correctEmail);
        //logger.info("Trying to send valid mail to field " + email.toString());
        return this;
    }

    //Ввод правильного пароля
    @Step("Entering the correct password")
    public AccountPage setValidPassword() {
        waiters.waitForVisibilityOfWebElement(authorizationPasswordField);
        authorizationPasswordField.sendKeys(Strings.correctPassword);
        //logger.info("Trying to send valid mail to field " + email.toString());
        return this;
    }
    //Ввод неправильного имейла
    @Step("Entering an incorrect email")
    public AccountPage setInvalidEmail() {
        waiters.waitForVisibilityOfWebElement(authorizationEmailField);
        authorizationEmailField.sendKeys(Strings.incorrectEmail);
        //logger.info("Trying to send valid mail to field " + email.toString());
        return this;
    }

    //Нажатие на кнопку Войти в окне авторизации
    @Step("Clicking the Login button in the authorization window")
    public AccountPage clickOnAuthorizationEnterButton(){
        authorizationEnterButton.click();
        return this;
    }

    //Подтвердить видимость сообщения о неуспешном входе в аккаунт
    @Step("Confirm visibility of the successful login message")
    public AccountPage visibilityOfUnsuccessfulLoginMessage(){
        waiters.waitForVisibilityOfWebElement(authorizationFailedMessage);
        authorizationFailedMessage.isDisplayed();
        return this;
    }

    //Нажатие на кнопку Забыли пароль в окне авторизации
    @Step("Clicking the Forgot password button in the authorization window")
    public AccountPage clickOnForgotPasswordButton(){
        waiters.waitForVisibilityOfWebElement(forgotPasswordButton);
        forgotPasswordButton.click();
        return this;
    }

    //Проверить наличие поля для ввода email на странице Забыли пароль
    @Step("Check the availability of the email field on the Forgot password page")
    public AccountPage visibilityOfEmailFieldOnForgotPasswordPage(){
        forgotPasswordEmailField.isDisplayed();
        return this;
    }

    //Нажатие на кнопку История заказов в Личном кабинете
    @Step("Clicking on the Order History button in your Personal Account")
    public AccountPage clickOnOrderHistoryButton(){
        orderHistoryButton.click();
        return this;
    }

    //Подтвердить видимость названия колонки № Заказа
    @Step("Confirm the visibility of the column name Order No.")
    public AccountPage visibilityOfOrderNumberColumnText(){
        orderNumberColumnText.isDisplayed();
        return this;
    }

    //Нажатие на кнопку Выход в верхнем меню
    @Step("Clicking the Exit button in the top menu")
    public AccountPage clickOnLogoutButtonFromMenu(){
        personalAccountButton.click();
        waiters.waitForVisibilityOfWebElement(logoutButton);
        logoutButton.click();
        return this;
    }

    //Нажатие на кнопку Подтвердить для выхода из личного кабинета
    @Step("Clicking the Confirm button to exit your personal account")
    public AccountPage clickOnContinueLogoutButton(){
        waiters.waitForVisibilityOfWebElement(continueLogoutButton);
        continueLogoutButton.click();
        return this;
    }

}
