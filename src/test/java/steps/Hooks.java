package steps;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import browser.Browser;
import browser.BrowserProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import reporter.ExtentManager;

public class Hooks {
    private static WebDriver driver;
    public static ExtentReports extent;
    public static ExtentTest test;

    @Before
    public void setUp(Scenario scenario){
        driver = BrowserProvider.createDriver(Browser.CHROME);
        extent = ExtentManager.getInstance();
        test = extent.createTest(scenario.getName(), scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario){
        extent.flush();
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void captureScreenshot(String status, String step){
        try{
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshotBytes = ts.getScreenshotAs(OutputType.BYTES);
            String screenshotPath = "screenshots/"+System.currentTimeMillis()+".png";
            FileUtils.writeByteArrayToFile(new File(screenshotPath), screenshotBytes);
            if(status.equals("pass")){
                Hooks.test.pass(step,MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }else{
                Hooks.test.fail(step,MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
