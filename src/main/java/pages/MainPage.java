package pages;
import constants.Url;
import functions.WaitersClass;
import functions.WorkWithElementClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private static class Strings{}

    // сбор локаторов
    @FindBy(xpath = "//p[text()='Welcome to']")
    private static WebElement welcomeString;

    @FindBy(xpath = "//*[@id=\"lm_3_Modal\"]/div/div/div[1]/button")
    private static WebElement rusLanguageButton;

    // открываем главную страницу
    public MainPage openMainPage(){
        driver.get(Url.DRSMOKE_HOME_PAGE);
        return this;
    }

    //выбор языка сайта на всплывающем окне
    public MainPage chooseRusLanguageOnModalWindow(){
        rusLanguageButton.click();
        return this;
    }


    //Проверка доступности главной страницы по надписи Welcome to
    public MainPage waitForVisibilityOfWelcomeString(){
        waiters.waitForVisibilityOfWebElement(welcomeString);
        return this;
    }
    //выбор пункта в селект-списке Личный кабинет
}
