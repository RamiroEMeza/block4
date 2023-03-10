package com.solvd.laba.carina.demo.gui.pages.homework;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.testng.Assert;

public class SearchResultPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//form[@action='/search']")
    private ExtendedWebElement searchForm;

    @FindBy(xpath = "//input[@name='q']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//form/div/div/div/center/input[@name='btnK' and @role='button']")
    private ExtendedWebElement clearSearchinput;

    @FindBy(xpath = "//a[@class='gb_e']")
    private ExtendedWebElement googleApps;

    @FindBy(xpath = "//a[@class='f1']")
    private List<ExtendedWebElement> pages;

    @FindBy(xpath="//div[@id='rcnt']//div//a/h3")
    private List<ExtendedWebElement> titlesResults;

    @FindBy(xpath="//div[@id='rcnt']//div/span//em")
    private List<ExtendedWebElement> descriptionResults;
    @FindBy(xpath = "//div[@role='navigation']")
    private ExtendedWebElement pageNavigation;

    public SearchResultPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchForm);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public SearchResultPage search(String subject){
        searchInput.type(subject);
        searchButton.click();
        return new SearchResultPage(driver);
    }

    public void checkSearch(String subject){
        Assert.assertFalse(titlesResults.isEmpty());
        Assert.assertFalse(descriptionResults.isEmpty());
        LOGGER.info("TITLES " + titlesResults.size());
        titlesResults.forEach(t -> {
            LOGGER.info(titlesResults.indexOf(t)+ " text = " + t.getText());
        });
        LOGGER.info("DESCRIPTIONS " + descriptionResults.size());
        descriptionResults.forEach(d -> {
            LOGGER.info(descriptionResults.indexOf(d)+ " text = " + d.getText());
        });
//        AtomicInteger titlesAppearances = new AtomicInteger();
//        AtomicInteger descriptionAppearances = new AtomicInteger();
//        titlesResults.forEach(t -> {
//            if (StringUtils.containsIgnoreCase(t.getText(), subject)){
//                titlesAppearances.getAndIncrement();
//            }
//        });
//        descriptionResults.forEach(d -> {
//            if (StringUtils.containsIgnoreCase(d.getText(), subject)){
//                descriptionAppearances.getAndIncrement();
//            }
//        });
//        Assert.assertTrue(titlesAppearances.get()>0);
//        Assert.assertTrue(descriptionAppearances.get()>0);
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
