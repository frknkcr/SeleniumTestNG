package tests.amazonTest;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class Test01_Search {

    @Test
    public void test01(){

        AmazonPage amazonPage = new AmazonPage();

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        amazonPage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        String actualSearchText = amazonPage.aramaSonucElementi.getText();
        String expectedSearchText = "Nutella";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actualSearchText.contains(expectedSearchText));

        softAssert.assertAll();

        Driver.closeDriver();
    }
}
