package tests.otherTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class Test03_IFrame {

    @Test
    public void test01(){

        //1- Bir Class olusturalim KeyboardActions2
        //2- https://html.com/tags/iframe/ sayfasina gidelim
        Driver.getDriver().get("https://html.com/tags/iframe/");

        //3- video’yu gorecek kadar asagi inin
        WebElement videoIframe = Driver.getDriver().findElement(By.xpath("//*[@id='post-164']/div/div[3]/iframe"));

        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView();",videoIframe);

        //4- videoyu izlemek icin Play tusuna basin
        Driver.getDriver().switchTo().frame(videoIframe);
        Driver.getDriver().findElement(By.xpath("//*[@aria-label='Oynat']")).click();

        //5- videoyu calistirdiginizi test edin

    }

}
