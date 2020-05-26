package ru.awg.examples.uitest.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.nio.charset.StandardCharsets;

public class TestListener implements ITestListener {

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Page screenshot", type = "image/png")
    private static byte[] getScreenshotBytes() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);

    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Page source", type = "text/html", fileExtension = "html")
    private static byte[] getPageSourceBytes() {
        return WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }
    @Override
    public void onTestFailure(ITestResult result) {
        getScreenshotBytes();
        getPageSourceBytes();
    }
}
