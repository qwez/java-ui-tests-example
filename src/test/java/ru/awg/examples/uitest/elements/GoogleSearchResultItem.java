package ru.awg.examples.uitest.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

public class GoogleSearchResultItem extends BaseElement {
    private final By link = By.cssSelector("div.r a");

    GoogleSearchResultItem(SelenideElement element) {
        super(element);
    }

    public SelenideElement targetLink() {
        return getElement(link);
    }

}
