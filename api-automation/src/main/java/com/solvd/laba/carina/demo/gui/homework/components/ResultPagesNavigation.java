package com.solvd.laba.carina.demo.gui.homework.components;

import com.solvd.laba.carina.demo.gui.homework.pages.SearchResultPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class ResultPagesNavigation extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@id='botstuff']//table//a")
    private List<ExtendedWebElement> resultPagesLinks;


    public ResultPagesNavigation(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchResultPage changePage(String label) {
        for (ExtendedWebElement resultPageLink : resultPagesLinks) {
            if (resultPageLink.getText().contains(label)) {
                resultPageLink.click();
                return new SearchResultPage(driver);
            }
        }
        return null;
    }

    public ExtendedWebElement checkCorrectPageIsOpen(String label) {
        for (ExtendedWebElement resultPageLink : resultPagesLinks) {
            if (resultPageLink.getText().contains(label)) {
                return resultPageLink;
            }
        }
        return null;
    }


}