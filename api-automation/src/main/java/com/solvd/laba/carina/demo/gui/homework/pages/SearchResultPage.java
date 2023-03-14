package com.solvd.laba.carina.demo.gui.homework.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.laba.carina.demo.gui.homework.components.ResultPagesNavigation;
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

    @FindBy(xpath = "//div[@id='rcnt']//div//a[not(ancestor::div[@class='g'])]/h3")
    private List<ExtendedWebElement> titlesResults;

    @FindBy(xpath = "//div[@id='rcnt']//div/span//em")
    private List<ExtendedWebElement> descriptionResults;
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

    public void checkSearch(String subject) {
        Assert.assertFalse(titlesResults.isEmpty());
        Assert.assertFalse(descriptionResults.isEmpty());
        AtomicInteger appearances = new AtomicInteger();
        SoftAssert softAssert = new SoftAssert();
        titlesResults.forEach(t -> {
            if (t.isElementPresent() && t.isVisible() && StringUtils.containsIgnoreCase(t.getText(), subject)) {
                appearances.getAndIncrement();
            }
        });
        descriptionResults.forEach(d -> {
            if (d.isElementPresent() && d.isVisible() && StringUtils.containsIgnoreCase(d.getText(), subject)) {
                appearances.getAndIncrement();
            }
        });

        Assert.assertTrue((appearances.get() > 0), "0 titles related!");
    }

    public ResultPagesNavigation getPages() {
        return pagesNavigation;
    }

    public SearchResultPage changePage(String label) {
        return this.pagesNavigation.changePage(label);
    }

    public void checkCorrectPageIsOpen(String label) {
        ExtendedWebElement check = this.pagesNavigation.checkCorrectPageIsOpen(label);
        Assert.assertTrue((check == null), "Correct page is not opened!");
    }


}
