package com.solvd.laba.carina.demo.gui.homework.components;

import com.solvd.laba.carina.demo.gui.homework.pages.FaqPolicyPage;
import com.solvd.laba.carina.demo.gui.homework.pages.InfoPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class PoliciesNavigation extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[@data-g-action='home']")
    private ExtendedWebElement info;
    @FindBy(xpath = "//header//a[contains(@href, \"%s\" )]")
    private ExtendedWebElement button;

    public PoliciesNavigation(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public FaqPolicyPage openFaq() {
        button.format("faq").click();
        return new FaqPolicyPage(driver);
    }


}