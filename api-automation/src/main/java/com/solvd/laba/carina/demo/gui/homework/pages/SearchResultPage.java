package com.solvd.laba.carina.demo.gui.homework.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.laba.carina.demo.gui.homework.components.ResultPagesNavigation;
import com.solvd.laba.carina.demo.gui.homework.components.SearchItem;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class SearchResultPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[@name='q']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//div[@id='search']")
    private SearchItem searchItem;


    @FindBy(xpath = "//div[@id='botstuff']//table")
    private ResultPagesNavigation pagesNavigation;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchInput);
    }

    public SearchResultPage search(String subject) {
        searchInput.type(subject);
        searchButton.click();
        return new SearchResultPage(driver);
    }


    public ResultPagesNavigation getPages() {
        return pagesNavigation;
    }

    public SearchItem getSearchItem() {
        return searchItem;
    }
}
