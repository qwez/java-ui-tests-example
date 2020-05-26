package ru.awg.examples.uitest.app;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

public class Application {
    private static String googleUrl;
    private static String openUrl;

    public static void setGoogleUrl(String url) {
        googleUrl = url;
    }
    public static void setOpenUrl(String url) {
        openUrl = url;
    }


    @Step("Открываем страницу google.com")
    public Google openGoogleMainPage() {
        openBaseUrl(googleUrl);
        return new Google();
    }

    private void openBaseUrl(String url) {
        if (url == null) {
            throw new RuntimeException("set base url first");
        }
        Selenide.open(googleUrl);
    }
}
