package com.solvd.laba.carina.demo.gui.homework.pages;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.laba.carina.demo.gui.homework.components.AboutGoogleNavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.testng.Assert;

public class ProductPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//div[@id='panel-1']//a[contains(@class, 'product-link')]")
    private List<ExtendedWebElement> googleProductsList;
    @FindBy(xpath = "//header//nav")
    private AboutGoogleNavigation aboutGoogleNavigation;
    @FindBy(xpath = "//header//img")
    private ExtendedWebElement googleLogo;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(googleLogo);
    }

    public void checkGoogleProductsList() {
        Assert.assertFalse(googleProductsList.isEmpty());
        googleProductsList.forEach(product -> {
            Assert.assertTrue(product.isClickable(), "Link is not clickable!");
            Assert.assertTrue(product.isVisible(), "Link is not visible!");
        });
    }

    public AboutGoogleNavigation getAboutGoogleNavigation() {
        return aboutGoogleNavigation;
    }

}
