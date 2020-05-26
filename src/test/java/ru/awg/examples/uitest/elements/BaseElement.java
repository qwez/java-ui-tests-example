package ru.awg.examples.uitest.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

abstract class BaseElement {
    private SelenideElement parent;

    protected BaseElement(SelenideElement parent) {
        this.parent = parent;
    }

    protected BaseElement() {
    }

    protected SelenideElement getElement(By selector) {
        if (parent == null) {
            return Selenide.$(selector);
        }
        return parent.$(selector);
    }

    protected ElementsCollection getElements(By selector) {
        if (parent == null) {
            return Selenide.$$(selector);
        }
        return parent.$$(selector);
    }

    public void waitFor() {
        parent.shouldBe(Condition.visible);
    }
}
