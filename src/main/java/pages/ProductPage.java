package pages;
import constants.Url;
import functions.WaitersClass;
import functions.WorkWithElementClass;
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

    //Ввод текста в посковую строку
    public ProductPage sendTextInSearchField() {
        waiters.waitForVisibilityOfWebElement(searchField);
        searchField.sendKeys(ProductPage.Strings.textForSearchField);
        return this;
    }

    //Нажатие на кнопку Поиск
    public ProductPage clickOnSearchButton(){
        waiters.waitForVisibilityOfWebElement(searchButton);
        searchButton.click();
        return this;
    }

    //Переход в карточку товара
    public ProductPage clickOnProductCard(){
        waiters.waitForVisibilityOfWebElement(productImg);
        productImg.click();
        return this;
    }

    //Нажатие на выбор цвета Tiger
    public ProductPage clickOnTigerColor(){
        waiters.waitForVisibilityOfWebElement(selectColorTigerCheck);
        selectColorTigerCheck.click();
        return this;
    }

    //Нажатие на кнопку добавления в корзину
    public ProductPage clickOnAddToCartButton(){
        waiters.waitForVisibilityOfWebElement(addToCartButton);
        addToCartButton.click();
        return this;
    }

    //Подвердить открытие окна корзины
    public ProductPage visibilityOfCartWindow(){
        waiters.waitForVisibilityOfWebElement(cartWindow);
        cartWindow.isDisplayed();
        return this;
    }

    //Подвердить открытие видимости сообщения о необходимости выбрать цвет устройства
    public ProductPage visibilityOfAlertMessage(){
        waiters.waitForVisibilityOfWebElement(messageNeedToChooseColor);
        messageNeedToChooseColor.isDisplayed();
        return this;
    }

    //Нажатие на кнопку добавления в закладки
    public ProductPage clickOnAddToWishlistButton(){
        addToWishlistButton.click();
        return this;
    }

    //Подвердить открытие окна Добавлено в закладки
    public ProductPage visibilityOfAddedToWishlistWindow(){
        waiters.waitForVisibilityOfWebElement(addedToWishlistWindow);
        addedToWishlistWindow.isDisplayed();
        return this;
    }


    //Нажатие на кнопку добавления в сравнение
    public ProductPage clickOnAddToCompareButton(){
        //waiters.waitForVisibilityOfWebElement(addToWishlistButton);
        addToCompareButton.click();
        return this;
    }
    //Подвердить открытие окна Добавлено в сравнение
    public ProductPage visibilityOfAddedToCompareWindow(){
        waiters.waitForVisibilityOfWebElement(addedToCompareWindow);
        addedToCompareWindow.isDisplayed();
        return this;
    }

}
