package abstractpages;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Listener implements ITestListener {

    private static final Logger logger = LogManager.getLogger(Listener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Test started "+ result.getName());
        }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test successes "+ result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Fail test " + result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
