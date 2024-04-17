package functions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WaitersClass {
    private WebDriver driver;

    public WaitersClass(WebDriver driver) {
        this.driver = driver;
    }

    private FluentWait<WebDriver> fluentWait() {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class)
                .ignoring(InvalidElementStateException.class)
                .ignoring(NoAlertPresentException.class)
                .ignoring(NoSuchFrameException.class);
    }

    public void waitForVisibilityOfWebElement(WebElement element){
        fluentWait().until(ExpectedConditions.visibilityOf(element));
    }

    public void switchToFrame(WebElement element){
        fluentWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
    }

}
