package pages;
import constants.Url;
import functions.WaitersClass;
import functions.WorkWithElementClass;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

        private final static String textForSearchField = "by Plus Pod Kit";

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
    @FindBy(xpath = "//input[@class='input-lg']")
    private static WebElement searchField;
    @FindBy(id = "oct-search-button")
    private static WebElement searchButton;
    @FindBy(xpath = "//img[@alt='Smoant Charon Baby Plus Pod Kit']")
    private static WebElement productImg;
    @FindBy(xpath = "//input[@value='9471']")
    private static WebElement selectColorTigerCheck;
    @FindBy(xpath = "//a[@id='button-cart']")
    private static WebElement addToCartButton;
    @FindBy(id = "popup-cart-inner")
    private static WebElement cartWindow;
    @FindBy(xpath = "//div[@class='text-danger']")
    private static WebElement messageNeedToChooseColor;
    @FindBy(xpath = "//a[@class='oct-button button-wishlist tooltipstered']")
    private static WebElement addToWishlistButton;
    @FindBy(id = "wishlist-popup")
    private static WebElement addedToWishlistWindow;
    @FindBy(xpath = "//a[@class='oct-button button-compare tooltipstered']")
    private static WebElement addToCompareButton;
    @FindBy(id = "compare-popup")
    private static WebElement addedToCompareWindow;

    //Открытие главной страницы
    @Step("Opening the main page")
    public ProductPage openMainPage() {
        driver.get(Url.DRSMOKE_HOME_PAGE);
        return this;
    }

    //Выбор языка сайта на всплывающем окне
    @Step("Selecting the site language in the pop-up window")
    public ProductPage chooseRusLanguageOnModalWindow() {
        waiters.waitForVisibilityOfWebElement(rusLanguageButton);
        rusLanguageButton.click();
        return this;
    }

    //выбор пункта Авторизация в выпадающем списке Личный кабинет
    @Step("selecting the Authorization item in the Personal Account drop-down list")
    public ProductPage selectAuthorizationButton(){
        personalAccountButton.click();
        waiters.waitForVisibilityOfWebElement(authorizationButton);
        authorizationButton.click();
        return this;
    }
    //Ввод правильного имейла
    @Step("Entering the correct email")
    public ProductPage setValidEmail() {
        waiters.waitForVisibilityOfWebElement(authorizationEmailField);
        authorizationEmailField.sendKeys(Strings.correctEmail);
        //logger.info("Trying to send valid mail to field " + email.toString());
        return this;
    }

    //Ввод правильного пароля
    @Step("Entering the correct password")
    public ProductPage setValidPassword() {
        waiters.waitForVisibilityOfWebElement(authorizationPasswordField);
        authorizationPasswordField.sendKeys(Strings.correctPassword);
        //logger.info("Trying to send valid mail to field " + email.toString());
        return this;
    }

    //Нажатие на кнопку Войти в окне авторизации
    @Step("Clicking the Login button in the authorization window")
    public ProductPage clickOnAuthorizationEnterButton(){
        authorizationEnterButton.click();
        return this;
    }

    //Ввод текста в посковую строку
    @Step("Entering text into the search bar")
    public ProductPage sendTextInSearchField() {
        waiters.waitForVisibilityOfWebElement(searchField);
        searchField.sendKeys(ProductPage.Strings.textForSearchField);
        return this;
    }

    //Нажатие на кнопку Поиск
    @Step("Clicking the Search button")
    public ProductPage clickOnSearchButton(){
        waiters.waitForVisibilityOfWebElement(searchButton);
        searchButton.click();
        return this;
    }

    //Переход в карточку товара путем нажатия на изображение товара
    @Step("Go to the product card by clicking on the product image")
    public ProductPage clickOnProductCard(){
        waiters.waitForVisibilityOfWebElement(productImg);
        productImg.click();
        return this;
    }

    //Нажатие на выбор цвета Tiger
    @Step("Click on Tiger color selection")
    public ProductPage clickOnTigerColor(){
        waiters.waitForVisibilityOfWebElement(selectColorTigerCheck);
        selectColorTigerCheck.click();
        return this;
    }

    //Нажатие на кнопку добавления в корзину
    @Step("Clicking the add to cart button")
    public ProductPage clickOnAddToCartButton(){
        waiters.waitForVisibilityOfWebElement(addToCartButton);
        addToCartButton.click();
        return this;
    }

    //Подтвердить открытие окна корзины
    @Step("Confirm opening of the cart window")
    public ProductPage visibilityOfCartWindow(){
        waiters.waitForVisibilityOfWebElement(cartWindow);
        cartWindow.isDisplayed();
        return this;
    }

    //Подтвердить открытие видимости сообщения о необходимости выбрать цвет устройства
    @Step("Confirm opening the visibility of the message about the need to select a device color")
    public ProductPage visibilityOfAlertMessage(){
        waiters.waitForVisibilityOfWebElement(messageNeedToChooseColor);
        messageNeedToChooseColor.isDisplayed();
        return this;
    }

    //Нажатие на кнопку добавления в закладки
    @Step("Clicking the add to wishlist button")
    public ProductPage clickOnAddToWishlistButton(){
        addToWishlistButton.click();
        return this;
    }

    //Подтвердить открытие окна Добавлено в закладки
    @Step("Confirm window opening Added to wishlist")
    public ProductPage visibilityOfAddedToWishlistWindow(){
        waiters.waitForVisibilityOfWebElement(addedToWishlistWindow);
        addedToWishlistWindow.isDisplayed();
        return this;
    }

    //Нажатие на кнопку добавления в сравнение
    @Step("Clicking the add to compare button")
    public ProductPage clickOnAddToCompareButton(){
        //waiters.waitForVisibilityOfWebElement(addToWishlistButton);
        addToCompareButton.click();
        return this;
    }
    //Подтвердить открытие окна Добавлено в сравнение
    @Step("Confirm opening window Added to compare")
    public ProductPage visibilityOfAddedToCompareWindow(){
        waiters.waitForVisibilityOfWebElement(addedToCompareWindow);
        addedToCompareWindow.isDisplayed();
        return this;
    }

}
