package pages;
import constants.Url;
import functions.WaitersClass;
import functions.WorkWithElementClass;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MainPage {
    public WebDriver driver;
    public WaitersClass waiters;
    public WorkWithElementClass workWithElement;



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
    private static WebElement fieldRepeatPassword;
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
    public MainPage openMainPage() {
        driver.get(Url.DRSMOKE_HOME_PAGE);
        return this;
    }

    //Выбор языка сайта на всплывающем окне
    public MainPage chooseRusLanguageOnModalWindow() {
        waiters.waitForVisibilityOfWebElement(rusLanguageButton);
        rusLanguageButton.click();
        return this;
    }

    //Проверка доступности главной страницы по надписи Welcome to
    public MainPage visibilityOfWelcomeString() {
        waiters.waitForVisibilityOfWebElement(welcomeString);
        return this;
    }

    //Ввод текста в посковую строку
    public MainPage sendTextInSearchField() {
        waiters.waitForVisibilityOfWebElement(searchField);
        searchField.sendKeys(Strings.textForSearchField);
        return this;
    }

    //Нажатие на кнопку Поиск
    public MainPage clickOnSearchButton(){
        searchButton.click();
        return this;
    }

    //Проверка наличия правильного заголовка поиска товара на странице поиска
    public MainPage checkingSearchHeaderCorrectVisibility(){
        waiters.waitForVisibilityOfWebElement(headerFromSearchPage);
        return this;
    }


    //выбор пункта Регистрация в выпадающем списке Личный кабинет
    public MainPage selectRegistrationButton(){
        personalAccountButton.click();
        registerButton.click();
        return this;
    }

    // Проверка открытия страницы регистрации по наличию поля Подтвердите пароль
    public MainPage checkingEnabledFieldRepeatPassword(){
        waiters.waitForVisibilityOfWebElement(fieldRepeatPassword);
        return this;
    }

    // Открыть страницу Доставка и оплата
    public MainPage openDeliveryAndPaymentPage(){
        deliveryAndPaymentPageButton.click();
        return this;
    }

    // Проверка наличия полей Доставка и Оплата
    public MainPage visibilityOfDeliveryAndPaymentHeaders(){
        headerDelivery.isDisplayed();
        headerPayment.isDisplayed();
        return this;
    }

    //Проверить что текстовый заголовок на странице на русском языке
    public MainPage ifThereIsRusTextInTitle(){
        Assert.assertEquals(topTitle.getText(), "ИНТЕРНЕТ МАГАЗИН ЭЛЕКТРОННЫХ СИГАРЕТ");
        return this;
    }

    //Переключить язык сайта на украинский с помощью кнопки на главной странице
    public MainPage clickUkrLanguageButton(){
        languageButtonHeader.click();
        return this;
    }

    //Проверить что текстовый заголовок на странице на русском языке
    public MainPage ifThereIsUkrTextInTitle(){
        Assert.assertEquals(topTitle.getText(), "ІНТЕРНЕТ МАГАЗИН ЕЛЕКТРОННИХ СИГАРЕТ");
        return this;
    }
}
