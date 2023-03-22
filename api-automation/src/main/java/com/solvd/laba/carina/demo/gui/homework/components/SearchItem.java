package com.solvd.laba.carina.demo.gui.homework.components;

import com.solvd.laba.carina.demo.gui.homework.pages.FaqPolicyPage;
import com.solvd.laba.carina.demo.gui.homework.pages.TermsPolicyPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchItem extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[not(ancestor::div[@class='g'])]/h3")
    private List<ExtendedWebElement> titlesResults;

    @FindBy(xpath = "//div/span//em")
    private List<ExtendedWebElement> descriptionResults;

    public SearchItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void checkSearch(String subject) {
        Assert.assertFalse(titlesResults.isEmpty());
        Assert.assertFalse(descriptionResults.isEmpty());
        AtomicInteger appearances = new AtomicInteger();
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

}