package tests.amazonTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.Screenshot;

public class Test02_Screenshot {

    @Test
    public void test01(){

        AmazonPage amazonPage = new AmazonPage();

        //1- amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        String expectedTitle = "Amazon";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));

        Screenshot.tumSayfaScreenshot(Driver.getDriver());

        //3- Nutella icin arama yapin
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
        WebElement sonucText = amazonPage.aramaSonucElementi;
        String expectedIcerik = "Nutella";
        String actualSonucText = sonucText.getText();

        Assert.assertTrue(actualSonucText.contains(expectedIcerik));

        Screenshot.webElementScreenshot(sonucText);

        Driver.closeDriver();



    }

}
