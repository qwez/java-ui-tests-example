package ru.awg.examples.uitest.elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class OpenBankCurrencyExchangeWidget extends BaseElement {
    private final By row = By.cssSelector("tr.main-page-exchange__row");

    public OpenBankCurrencyExchangeWidget(SelenideElement element) {
        super(element);
    }

    public List<Row> currencyRows() {
        return getElements(row).stream()
                .map(Row::new)
                .collect(Collectors.toList());
    }

    public static class Row extends BaseElement {
        private final By currency = By.cssSelector("span.main-page-exchange__currency-name");
        private final By rate = By.cssSelector("span.main-page-exchange__rate");
        private Row(SelenideElement element) {
            super(element);
        }

        public SelenideElement currencyName() {
            return getElement(currency);
        }

        public ElementsCollection ratesBuySell() {
            return getElements(rate);
        }
    }
}
