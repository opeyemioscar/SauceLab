package listener;

import java.io.IOException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.BaseClass;
public class Listeners extends BaseClass implements ITestListener {
	 static Date d = new Date();
	    static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	    private static ExtentReports extent = ExtentManager.getInstance(System.getProperty("user.dir") + "/test-output/ExtentReport/" + fileName);
	    public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
   
    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName());
        testReport.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	testReport.get().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	testReport.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
    	testReport.get().fail(result.getThrowable());

        // Capture screenshot on failure
        ExtentManager extentManager = new ExtentManager();
        try {
            extentManager.screenShot();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    	testReport.get().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
    	testReport.get().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
