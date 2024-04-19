package pages;
import constants.Url;
import functions.WaitersClass;
import functions.WorkWithElementClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class MainPage {
    public WebDriver driver;
    public WaitersClass waiters;
    public WorkWithElementClass workWithElement;

    static final Logger logger = LoggerFactory.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        this.driver = driver;
        waiters = new WaitersClass(driver);
        workWithElement = new WorkWithElementClass(driver);
        PageFactory.initElements(driver,this);
    }

    //сбор стринговых данных
    private static class Strings {
        private final static String textForSearchField = "картридж";
    }

    // сбор локаторов
    @FindBy(xpath = "//p[text()='Welcome to']")
    private static WebElement welcomeString;
    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    private static WebElement rusLanguageButton;
    @FindBy(xpath = "//*[@class='input-lg']")
    private static WebElement searchField;
    @FindBy(id = "oct-search-button")
    private static WebElement searchButton;
    @FindBy(xpath = "//*[text()='Поиск - " + Strings.textForSearchField + "']")
    private static WebElement headerFromSearchPage;
    @FindBy(xpath = "//span[@class='hidden-xs hidden-sm hidden-md']")
    private static WebElement personalAccountButton;
    @FindBy(xpath = "//a[text()='Регистрация']")
    private static WebElement registerButton;
    @FindBy(id = "register_confirm_password")
    private static WebElement fieldConfirmPassword;
    @FindBy(xpath = "(//a[@href=\"https://drsmoke.org/oplata-i-dostavka\"])[1]")
    private static WebElement deliveryAndPaymentPageButton;
    @FindBy(xpath = "//h3[text()='СПОСОБЫ ОПЛАТЫ']")
    private static WebElement headerPayment;
    @FindBy(xpath = "//h3[text()='СПОСОБЫ ДОСТАВКИ']")
    private static WebElement headerDelivery;
    @FindBy(xpath = "//div[@class='web-top-title']")
    private static WebElement topTitle;
    @FindBy(xpath = "(//button[text()='УКР'])[2]")
    private static WebElement languageButtonHeader;

    //Открытие главной страницы
    @Step("Opening the main page")
    public MainPage openMainPage() {
        driver.get(Url.DRSMOKE_HOME_PAGE);
        logger.info("Trying to open Main page");
        return this;
    }

    //Выбор языка сайта на всплывающем окне
    @Step("Selecting the site language in the pop-up window")
    public MainPage chooseRusLanguageOnModalWindow() {
        waiters.waitForVisibilityOfWebElement(rusLanguageButton);
        rusLanguageButton.click();
        logger.info("Trying to select the site language RUS in the pop-up window");
        return this;
    }

    //Проверка доступности главной страницы по надписи Welcome to
    @Step("Checking the availability of the main page using the Welcome to inscription")
    public MainPage visibilityOfWelcomeString() {
        waiters.waitForVisibilityOfWebElement(welcomeString);
        logger.info("Checking the availability of the main page using the Welcome to inscription");
        return this;
    }

    //Ввод текста в посковую строку
    @Step("Entering text into the search field")
    public MainPage sendTextInSearchField() {
        waiters.waitForVisibilityOfWebElement(searchField);
        searchField.sendKeys(Strings.textForSearchField);
        logger.info("Entering text" + Strings.textForSearchField + "into the search field");
        return this;
    }

    //Нажатие на кнопку Поиск
    @Step("Clicking the Search button")
    public MainPage clickOnSearchButton(){
        searchButton.click();
        logger.info("Clicking the Search button");
        return this;
    }

    //Проверка наличия правильного заголовка поиска товара на странице поиска
    @Step("Checking for the correct searched product search title on the search page")
    public MainPage checkingSearchHeaderCorrectVisibility(){
        waiters.waitForVisibilityOfWebElement(headerFromSearchPage);
        logger.info("Checking for the correct searched product search title on the search page");
        return this;
    }


    //Выбор пункта Регистрация в выпадающем списке Личный кабинет
    @Step("Selecting the Registration button in the Personal Account drop-down list")
    public MainPage selectRegistrationButton(){
        personalAccountButton.click();
        registerButton.click();
        logger.info("Selecting the Registration button in the Personal Account drop-down list");
        return this;
    }

    // Проверка открытия страницы регистрации по наличию поля Подтвердите пароль
    @Step("Checking the opening of the registration page by the presence of the Confirm password field")
    public MainPage checkingEnabledFieldConfirmPassword(){
        waiters.waitForVisibilityOfWebElement(fieldConfirmPassword);
        fieldConfirmPassword.isDisplayed();
        logger.info("Checking the opening of the registration page by the presence of the Confirm password field");
        return this;
    }

    // Открыть страницу Доставка и оплата
    @Step("Open the page Delivery and payment")
    public MainPage openDeliveryAndPaymentPage(){
        deliveryAndPaymentPageButton.click();
        logger.info("Trying to open the page Delivery and payment");
        return this;
    }

    // Проверка наличия полей Доставка и Оплата
    @Step("Checking the presence of the Delivery and Payment fields")
    public MainPage visibilityOfDeliveryAndPaymentHeaders(){
        headerDelivery.isDisplayed();
        headerPayment.isDisplayed();
        logger.info("Checking the presence of the Delivery and Payment fields");
        return this;
    }

    //Проверить что текстовый заголовок на странице на русском языке
    @Step("Check that the text title on the page is in Russian")
    public MainPage ifThereIsRusTextInTitle(){
        Assert.assertEquals(topTitle.getText(), "ИНТЕРНЕТ МАГАЗИН ЭЛЕКТРОННЫХ СИГАРЕТ");
        logger.info("Checking that the text title on the page is in Russian");
        return this;
    }

    //Переключить язык сайта на украинский с помощью кнопки на главной странице
    @Step("Switch the site language to Ukrainian using the button on the main page")
    public MainPage clickUkrLanguageButton(){
        languageButtonHeader.click();
        logger.info("Switching the site language to Ukrainian using the button on the main page");
        return this;
    }

    //Проверить что текстовый заголовок на странице на украинском языке
    @Step("Check that the text title on the page is in Ukrainian")
    public MainPage ifThereIsUkrTextInTitle(){
        Assert.assertEquals(topTitle.getText(), "ІНТЕРНЕТ МАГАЗИН ЕЛЕКТРОННИХ СИГАРЕТ");
        logger.info("Checking that the text title on the page is in Ukrainian");
        return this;
    }
}
