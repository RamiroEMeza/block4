package com.solvd.laba.carina.demo.gui.components.homework;

import com.solvd.laba.carina.demo.gui.pages.homework.CommitmentsPage;
import com.solvd.laba.carina.demo.gui.pages.homework.InfoPage;
import com.solvd.laba.carina.demo.gui.pages.homework.ProductPage;
import com.solvd.laba.carina.demo.gui.pages.homework.StoriesPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class AboutGoogleNavigation extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//a[@data-g-action='home']")
    private ExtendedWebElement info;
    @FindBy(xpath = "//a[contains(@href, 'products')]")
    private ExtendedWebElement products;

    @FindBy(xpath = "//a[contains(@href, 'commitments')]")
    private ExtendedWebElement commitments;

    @FindBy(xpath = "//a[contains(@href, 'stories')]")
    private ExtendedWebElement stories;

    public AboutGoogleNavigation(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public InfoPage openInfoPage() {
        info.click();
        return new InfoPage(driver);
    }

    public ProductPage openProductPage() {
        products.click();
        return new ProductPage(driver);
    }

    public CommitmentsPage openCommitmentsPage() {
        commitments.click();
        return new CommitmentsPage(driver);
    }

    public StoriesPage openStoriesPage() {
        stories.click();
        return new StoriesPage(driver);
    }

}
