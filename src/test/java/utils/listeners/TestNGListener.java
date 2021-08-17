package utils.listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import utils.ReadQaProps;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static utils.driver.DriverManager.getDriver;

public class TestNGListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        ReadQaProps._init();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = iTestResult.getName();
        if(!iTestResult .isSuccess()){
            File scrFile = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
                FileUtils.deleteDirectory(new File(reportDirectory));
                File destFile = new File(reportDirectory +"/failure_screenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png");
                FileUtils.copyFile(scrFile, destFile);
                Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

