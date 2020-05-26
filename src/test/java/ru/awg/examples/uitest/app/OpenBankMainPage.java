package ru.awg.examples.uitest.app;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;
import ru.awg.examples.uitest.elements.OpenBankMainPageBody;
import ru.awg.examples.uitest.model.CurrencyExchangeRate;
import ru.awg.examples.uitest.util.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class OpenBankMainPage {
    private OpenBankMainPageBody body;

    private OpenBankMainPageBody mainBody() {
        if (body == null) {
            body = new OpenBankMainPageBody();
        }
        return body;
    }

    @Step("Получаем стоимость обмена всех валют в блоке «Курс обмена в интернет-банке»")
    public List<CurrencyExchangeRate> exchangeRates() {
        return mainBody()
                .exchangeWidget()
                .currencyRows()
                .stream()
                .map(r -> {
                    ElementsCollection rates = r.ratesBuySell();
                    // check size with ElementsCollection#shouldHaveSize
                    rates.shouldHaveSize(2);
                    return new CurrencyExchangeRate(
                            r.currencyName().text(),
                            Converter.parseCurrencyAmount(rates.get(0).getText()),
                            Converter.parseCurrencyAmount(rates.get(1).getText())
                    );
                }).collect(Collectors.toList());
    }
}
