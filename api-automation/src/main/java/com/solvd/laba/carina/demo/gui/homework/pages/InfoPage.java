package com.solvd.laba.carina.demo.gui.homework.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.laba.carina.demo.gui.homework.components.AboutGoogleNavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.testng.Assert;

public class InfoPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//header//nav")
    private AboutGoogleNavigation aboutGoogleNavigation;

    @FindBy(xpath = "//header//img")
    private ExtendedWebElement googleLogo;

    @FindBy(xpath = "//section//div//div//a")
    private List<ExtendedWebElement> googleLinks;

    @FindBy(xpath = "//section//div//a[contains(@href, 'products')]")
    private ExtendedWebElement products;

    public InfoPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(googleLogo);
    }

    public void checkLinks() {
        Assert.assertFalse(googleLinks.isEmpty(), "Info page doesn't have links!");
        googleLinks.forEach(link -> {
            Assert.assertTrue(link.isClickable(), "Link is not clickable!");
            Assert.assertTrue(link.isVisible(), "Link is not visible!");
        });
    }

    public AboutGoogleNavigation getAboutGoogleNavigation() {
        return aboutGoogleNavigation;
    }
}
