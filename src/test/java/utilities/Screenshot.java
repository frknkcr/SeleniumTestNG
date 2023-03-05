package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

    static TakesScreenshot takesScreenshot;

    public static void tumSayfaScreenshot(WebDriver driver){

        takesScreenshot = (TakesScreenshot) driver;

        File tumSayfaSs = new File("F:/Selenium/TestScreenshot/screenshot_"+getCurrentDateTime()+".png");

        File geciciResim = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciResim,tumSayfaSs);
        } catch (IOException e) {

        }
    }

    public static void webElementScreenshot(WebElement element){

        File webElementSs = new File("F:/Selenium/TestScreenshot/webElementScreenshot_"+getCurrentDateTime()+".png");
        File geciciResim = element.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciResim,webElementSs);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCurrentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }

}
