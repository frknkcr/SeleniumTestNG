package tests.otherTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class Test05_Kiwi {

    @Test
    public void testKiwi() {

        // https://www.kiwi.com sayfasina gidin
        Driver.getDriver().get("https://www.kiwi.com");
        Driver.getDriver().findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1nfggrh-0 iFkUjC'])[3]")).click();

        // Sag ust kisimdan dil ve para birimi secenegini Turkiye ve TL olarak secin
        Driver.getDriver().findElement(By.xpath("(//div[@class='ButtonPrimitiveContent__StyledButtonPrimitiveContent-sc-1nfggrh-0 jIgbVC'])[7]")).click();

        WebElement language= Driver.getDriver().findElement(By.xpath("//select[@class='Select__StyledSelect-sc-2ijy2y-1 bStxNw']"));
        Select dilsecimi=new Select(language);
        dilsecimi.selectByVisibleText("Türkçe");

        WebElement currency= Driver.getDriver().findElement(By.xpath("//select[@class='Select__StyledSelect-sc-2ijy2y-1 jZBCHP']"));
        Select parabirimi=new Select(currency);
        parabirimi.selectByValue("try");
        Driver.getDriver().findElement(By.xpath("//*[text()='Kaydet ve devam et']")).click();

        // Sectiginiz dil ve para birimini dogrulayin
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//div[text()='TRY']")).getText().contains("TRY"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("tr"));

        // Ucus secenegi olarak tek yon secelim
        Driver.getDriver().findElement(By.xpath("(//*[text()='Gidiş Dönüş'])[1]")).click();
        Driver.getDriver().findElement(By.xpath("//*[text()='Tek Yön']")).click();

        // Kalkis ve varis boxlarini temizleyerek kalkis ve varis ulkesini kendimiz belirleyelim
        Driver.getDriver().findElement(By.xpath("(//*[@preserveAspectRatio='xMidYMid meet'])[29]")).click();
        WebElement kalkis= Driver.getDriver().findElement(By.xpath("(//input[@data-test='SearchField-input'])[1]"));
        kalkis.sendKeys("Istanbul");
        ReusableMethods.sleep(3);
        Driver.getDriver().findElement(By.xpath("(//div[@data-test='PlacePickerRow-wrapper'])[1]")).click();
        WebElement varis= Driver.getDriver().findElement(By.xpath("(//input[@data-test='SearchField-input'])[2]"));
        varis.sendKeys("Varsova");
        ReusableMethods.sleep(3);
        Driver.getDriver().findElement(By.xpath("(//div[@data-test='PlacePickerRow-wrapper'])[1]")).click();
        Driver.getDriver().findElement(By.xpath("//input[@data-test='SearchFieldDateInput']")).click();
        ReusableMethods.sleep(3);
        Driver.getDriver().findElement(By.xpath("//div[@data-value='2023-03-16']")).click();
        Driver.getDriver().findElement(By.xpath("//*[text()='Tarihleri ayarla']")).click();

        // Gidis tarihi kismina erisim saglayarak gidecegimiz gunu secelim ve booking i iptal edelim
        Driver.getDriver().findElement(By.xpath("//*[text()='Booking.com ile konaklama arayın']")).click();
        Driver.getDriver().findElement(By.xpath("//a[@data-test='LandingSearchButton']")).click();

    }
}
