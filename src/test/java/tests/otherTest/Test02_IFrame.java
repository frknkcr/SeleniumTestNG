package tests.otherTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;
import java.util.Set;

public class Test02_IFrame {

        @Test
        public void test01(){
            //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
            Driver.getDriver().get("http://demo.guru99.com/test/guru99home/");
            //2) sayfadaki iframe sayısını bulunuz.
            List<WebElement> iframeListi=Driver.getDriver().findElements(By.tagName("//iframe"));
            System.out.println(iframeListi.size());
            //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
            WebElement frame=Driver.getDriver().findElement(By.xpath("//iframe[@wmode='transparent']"));
            Driver.getDriver().switchTo().frame(frame);
            Driver.getDriver().findElement(By.xpath("//button[@aria-label='Oynat']")).click();
            ReusableMethods.sleep(3);
            //4) ilk iframe'den çıkıp ana sayfaya dönünüz
            Driver.getDriver().switchTo().parentFrame();
            //5) ikinci iframe'deki (Jmeter Made Easy) linke
            WebElement ikinciFrame=Driver.getDriver().findElement(By.id("a077aa5e"));
            JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoView();",ikinciFrame);
            Driver.getDriver().switchTo().frame(ikinciFrame);
            String ilkHnadle=Driver.getDriver().getWindowHandle();
            WebElement tiklama=Driver.getDriver().findElement(By.xpath("/html/body/a/img"));
            tiklama.click();
            ReusableMethods.sleep(3);
            //(https://www.guru99.com/live-selenium-project.html) tıklayınız
            Set<String> topHndle=Driver.getDriver().getWindowHandles();
            String ikinciHandle="";
            for (String each:topHndle
            ) {
                if (!each.equals(ilkHnadle)){
                    ikinciHandle=each;
                }
            }
            Driver.getDriver().switchTo().window(ikinciHandle);
            Driver.getDriver().findElement(By.xpath("(//a[text()='Home'])[1]")).click();
            ReusableMethods.sleep(3);
            Driver.quitDriver();
        }

}
