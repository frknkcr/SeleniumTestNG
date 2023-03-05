package tests.otherTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.Set;

public class Test01_Handle {

    @Test
    public void test01(){

        //1."http://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");

        //2."Login Portal" a kadar asagi inin
        WebElement loginPortalElement = Driver.getDriver().findElement(By.id("login-portal"));

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",loginPortalElement);

        //3."Login Portal" a tiklayin
        String ilkSayfaHandle = Driver.getDriver().getWindowHandle();
        loginPortalElement.click();

        //4.Diger window'a gecin
        Set<String> handles = Driver.getDriver().getWindowHandles();
        String ikinciSayfaHandle="";
        for (String each:handles) {
            if (!each.equals(ilkSayfaHandle)){
                ikinciSayfaHandle = each;
            }
        }
        Driver.getDriver().switchTo().window(ikinciSayfaHandle);

        //5."username" ve "password" kutularina deger yazdirin
        Driver.getDriver().findElement(By.xpath("//*[@id='text']")).sendKeys("usename");
        Driver.getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys("password");

        //6."login" butonuna basin
        Driver.getDriver().findElement(By.xpath("//*[@id='login-button']")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        String actualAlertText = Driver.getDriver().switchTo().alert().getText();
        String expectedAlertText = "validation failed";

        Assert.assertEquals(actualAlertText,expectedAlertText);

        //8.Ok diyerek Popup'i kapatin
        Driver.getDriver().switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        Driver.getDriver().switchTo().window(ilkSayfaHandle);

        //10.Ilk sayfaya donuldugunu test edin
        String actualHandle = Driver.getDriver().getWindowHandle();
        String expectedHandle = ilkSayfaHandle;

        Assert.assertEquals(actualHandle,expectedHandle);

        Driver.quitDriver();


    }
}
