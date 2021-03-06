package ru.awg.examples.uitest.tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.awg.examples.uitest.app.Application;
import ru.awg.examples.uitest.util.TestListener;

@Listeners(TestListener.class)
public class ExchangeRateWidgetTest extends BaseTest {
    private Application app;

    @BeforeMethod
    public void setUp() {
        app = new Application();
    }

    @Test(description = "Курс продажи должен быть больше курса покупки для всех валют в виджете на главной")
    public void sellRateShouldBeGreaterThenBuyRate() {
        SoftAssertions soft = new SoftAssertions();
        app.openGoogleMainPage()
                .search("Открытие")
                .clickOnOpenBankSearchResult()
                .exchangeRates()
                .forEach(rate -> soft.assertThat(rate.getSell())
                        .as("Курс продажи должен быть больше курса покупки для валюты " + rate.getName())
                        .isGreaterThan(rate.getBuy())
                );
        soft.assertAll();
    }
}
