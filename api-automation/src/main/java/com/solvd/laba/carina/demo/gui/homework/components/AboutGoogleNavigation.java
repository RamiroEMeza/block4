package com.solvd.laba.carina.demo.gui.homework.components;

import com.solvd.laba.carina.demo.gui.homework.pages.CommitmentsPage;
import com.solvd.laba.carina.demo.gui.homework.pages.InfoPage;
import com.solvd.laba.carina.demo.gui.homework.pages.ProductPage;
import com.solvd.laba.carina.demo.gui.homework.pages.StoriesPage;
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

    public final String PRODUCTS_LINK = "products";
    public final String COMMITMENTS_LINK = "commitments";
    public final String STORIES_LINK = "stories";
    @FindBy(xpath = "//a[@data-g-action='home']")
    private ExtendedWebElement info;
    @FindBy(xpath = "//a[contains(@href, '%s')]")
    private ExtendedWebElement navItem;


    public AboutGoogleNavigation(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public InfoPage openInfoPage() {
        info.click();
        return new InfoPage(driver);
    }

    public ProductPage openProductPage() {
        navItem.format(PRODUCTS_LINK).click();
        return new ProductPage(driver);
    }

    public CommitmentsPage openCommitmentsPage() {
        navItem.format(COMMITMENTS_LINK).click();
        return new CommitmentsPage(driver);
    }

    public StoriesPage openStoriesPage() {
        navItem.format(STORIES_LINK).click();
        return new StoriesPage(driver);
    }

}
