package ru.awg.examples.uitest.elements;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleSearchForm extends BaseElement {
    private final By search     = By.cssSelector("input[name=q]");
    private final By button     = By.cssSelector("input[name=btnK]");
    private final By resultItem = By.cssSelector("div#search div.g");

    public SelenideElement searchInput() {
        return getElement(search);
    }

    public SelenideElement searchButton() {
        return getElement(button);
    }

    public GoogleSearchResultItem firstResultItem() {
        return new GoogleSearchResultItem(getElement(resultItem));
    }

    public List<GoogleSearchResultItem> allResultItems() {
        return getElements(resultItem).stream()
                .map(GoogleSearchResultItem::new)
                .collect(Collectors.toList());
    }
}
