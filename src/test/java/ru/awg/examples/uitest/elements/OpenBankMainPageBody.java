package ru.awg.examples.uitest.elements;

import org.openqa.selenium.By;

public class OpenBankMainPageBody extends BaseElement {
    private final String info = "div[data-react-class=MainPageInfo]";
    private final By exchange = By.cssSelector(info + " div.main-page-exchange");

    public OpenBankCurrencyExchangeWidget exchangeWidget() {
        return new OpenBankCurrencyExchangeWidget(getElement(exchange));
    }
}
