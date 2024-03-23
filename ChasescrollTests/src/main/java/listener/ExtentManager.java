package listener;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseClass;

public class ExtentManager extends BaseClass {
	public ExtentSparkReporter htmlReporter;
	 public static ExtentReports extent;
	 public static ExtentTest test;
	public static ExtentReports getInstance(String fileName) throws IOException {
		
        if (extent == null) {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);
           
            htmlReporter.config().setTheme(Theme.DARK);
            htmlReporter.config().setDocumentTitle(fileName);
            htmlReporter.config().setEncoding("utf-8");
            htmlReporter.config().setReportName(fileName);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Automation Tester", "Rahul Arora");
            extent.setSystemInfo("Organization", "Way2Automation");
            extent.setSystemInfo("Build no", "W2A-1234");
        }
        return extent;

}
	public void screenShot() throws IOException {
		Date d = new Date();
		String screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = "C:\\Users\\hp\\eclipse-workspace\\ChasescrollTests\\ScreenShot\\"+screenshotName;
		FileUtils.copyFile(scrFile, new File(path));		
	}
}