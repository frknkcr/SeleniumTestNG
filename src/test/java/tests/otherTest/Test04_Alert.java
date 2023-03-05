package tests.otherTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class Test04_Alert {
    @Test
    public void test01(){
        //Yeni Class olusturun ActionsClassHomeWork
        //1- "" sayfasina gidin
        Driver.getDriver().get("http://webdriveruniversity.com/Actions");


        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//button[@class='dropbtn']"))).perform();

        //3- Link 1" e tiklayin
        Driver.getDriver().findElement(By.xpath("//a[text()='Link 1']")).click();

        //4- Popup mesajini yazdirin
        System.out.println(Driver.getDriver().switchTo().alert().getText());

        //5- Popup'i tamam diyerek kapatin
        Driver.getDriver().switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHoldElement = Driver.getDriver().findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHoldElement).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(clickAndHoldElement.getText());

        //8- “Double click me" butonunu cift tiklayin
        actions.doubleClick(Driver.getDriver().findElement(By.id("double-click"))).perform();

        WebElement sourceElement = Driver.getDriver().findElement(By.xpath("//div[@id='draggable']"));
        WebElement targetElement = Driver.getDriver().findElement(By.xpath("//div[@id='droppable']"));
        actions.dragAndDrop(sourceElement,targetElement).perform();

        ReusableMethods.sleep(5);

        Driver.closeDriver();
    }
}
