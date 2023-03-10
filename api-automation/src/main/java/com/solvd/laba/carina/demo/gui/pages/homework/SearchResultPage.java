package com.solvd.laba.carina.demo.gui.pages.homework;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.laba.carina.demo.gui.components.WeValuePrivacyAd;
import org.testng.Assert;

public class SearchResultPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//form[@action='/search']")
    private ExtendedWebElement searchForm;

    @FindBy(xpath = "//a[@class='gb_e']")
    private ExtendedWebElement googleApps;

    @FindBy(xpath = "//a[@class='f1']")
    private List<ExtendedWebElement> pages;

    @FindBy(xpath = "//div[@role='navigation']")
    private ExtendedWebElement pageNavigation;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchForm);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public SearchResultPage search(String subject){
        searchForm.findExtendedWebElement(By.name("q")).type(subject);
        searchForm.findExtendedWebElement(By.tagName("button")).click();
        return new SearchResultPage(driver);
    }

    public void checkSearch(String subject){
        List<WebElement> resultsLinks = driver.findElements(By.xpath("//h3[contains(text(), '"+subject+"')]"));
        Assert.assertFalse(resultsLinks.isEmpty());
    }

    public void changePage(int i) {
        Assert.assertTrue(pageNavigation.isElementPresent());
        driver.findElement(By.xpath("//td/a[contains(text(), '"+i+"')]")).click();
    }

    public ExtendedWebElement getGoogleApps() {
        return googleApps;
    }

    public List<ExtendedWebElement> getPages() {
        return pages;
    }


}
