package ru.awg.examples.uitest.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import ru.awg.examples.uitest.app.Application;
import ru.awg.examples.uitest.config.Config;

public abstract class BaseTest {

    @BeforeTest
    public void webDriverSetUp() {
        String driver = Config.properties.getProperty("browser.driver", "");
        if (!driver.equals("")) {
            System.setProperty("webdriver.chrome.driver", driver);
        }
        String res = Config.properties.getProperty("browser.resolution", "");
        if (!res.equals("")) {
            Configuration.browserSize = res;
        }
        Application.setGoogleUrl(Config.properties.getProperty("google.base_url"));
        Application.setOpenUrl(Config.properties.getProperty("open.base_url"));
    }
}
