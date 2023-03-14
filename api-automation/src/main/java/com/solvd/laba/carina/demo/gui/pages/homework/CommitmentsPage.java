package com.solvd.laba.carina.demo.gui.pages.homework;

import java.lang.invoke.MethodHandles;
import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.laba.carina.demo.gui.components.homework.AboutGoogleNavigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.testng.Assert;

public class CommitmentsPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//header//nav")
    private AboutGoogleNavigation aboutGoogleNavigation;
    @FindBy(xpath = "//section//div//a[contains(@href, 'reports')]")
    private ExtendedWebElement reports;
    @FindBy(xpath = "//header//img")
    private ExtendedWebElement googleLogo;

    @FindBy(xpath = "//section//div//picture//img")
    private List<ExtendedWebElement> googleCommitments;

    public CommitmentsPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(googleLogo);
    }

    public void checkReports() {
        Assert.assertTrue(reports.isElementPresent());
        Assert.assertTrue(reports.isClickable());
        Assert.assertTrue(reports.isVisible());
    }

    public void checkGoogleCommitments() {
        Assert.assertFalse(googleCommitments.isEmpty());
        googleCommitments.forEach(commitment -> {
            commitment.isClickable();
            commitment.isVisible();
        });
    }

    public AboutGoogleNavigation getAboutGoogleNavigation() {
        return aboutGoogleNavigation;
    }
}
