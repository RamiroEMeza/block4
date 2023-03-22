package com.solvd.laba.carina.demo.gui.homework.pages;


import java.lang.invoke.MethodHandles;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.laba.carina.demo.gui.homework.components.PoliciesNavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.gui.AbstractPage;

public class TermsPolicyPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//header//ul[@role=\"navigation\"]")
    private PoliciesNavigation policiesNavigation;

    @FindBy(xpath = "//header//img")
    private ExtendedWebElement googleLogo;

    public TermsPolicyPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(googleLogo);
    }

    public PoliciesNavigation getPoliciesNavigation() {
        return policiesNavigation;
    }
}