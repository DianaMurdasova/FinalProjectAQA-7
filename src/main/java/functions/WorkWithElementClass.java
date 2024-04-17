package functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WorkWithElementClass {
    private WebDriver driver;
    private WaiterClass waiter;

    public WorkWithElementClass(WebDriver driver) {
        this.driver = driver;
        waiter = new WaiterClass(driver);
    }

    public void click(WebElement element){
        waiter.waitForVisibilityOfWebElement(element);
        element.click();
    }

    public String getTextFromElement(WebElement element){
        waiter.waitForVisibilityOfWebElement(element);
        return element.getText();
    }

}
