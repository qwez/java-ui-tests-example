package ru.awg.examples.uitest.app;

import io.qameta.allure.Step;
import ru.awg.examples.uitest.config.Config;
import ru.awg.examples.uitest.elements.GoogleSearchForm;
import ru.awg.examples.uitest.elements.GoogleSearchResultItem;

public class Google {
    private GoogleSearchForm search;
    private GoogleSearchForm searchForm() {
        if (search == null) {
            search = new GoogleSearchForm();
        }
        return search;
    }

    @Step("Осуществляем поиск по фразе {0}")
    public Google search(String phrase) {
        searchForm().searchInput().append(phrase);
        searchForm().searchButton().click();
        return this;
    }

    @Step("Кликаем по результату поиска со ссылкой на Банк Открытие")
    public OpenBankMainPage clickOnOpenBankSearchResult() {
        searchForm().firstResultItem().waitFor();
        searchForm().allResultItems().stream()
                .map(GoogleSearchResultItem::targetLink)
                .filter(
                        l -> Config.properties.getProperty("open.base_url", "")
                                .equals(l.getAttribute("href"))
                ).findFirst()
                .orElseThrow(() -> new RuntimeException("open bank link not found or not been set"))
                .click();
        return new OpenBankMainPage();
    }
}
