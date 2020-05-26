package ru.awg.examples.uitest.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import ru.awg.examples.uitest.app.Application;
import ru.awg.examples.uitest.config.Config;

public abstract class BaseTest {

    @BeforeTest
    public void webDriverSetUp() {
        String driver = Config.getValue("browser.driver");
        if (!driver.equals("")) {
            System.setProperty("webdriver.chrome.driver", driver);
        }
        String res = Config.getValue("browser.resolution");
        if (!res.equals("")) {
            Configuration.browserSize = res;
        }
        Application.setGoogleUrl(Config.getValue("google.base_url"));
        Application.setOpenUrl(Config.getValue("open.base_url"));
    }
}
