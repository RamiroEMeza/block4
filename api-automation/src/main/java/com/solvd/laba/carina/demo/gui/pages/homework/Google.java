package com.solvd.laba.carina.demo.gui.pages.homework;

import java.lang.invoke.MethodHandles;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.laba.carina.demo.gui.components.WeValuePrivacyAd;
import org.testng.Assert;


public class Google extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//form[@action='/search']")
    private ExtendedWebElement searchForm;

    @FindBy(xpath = "//input[@name='q']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[@name='btnK']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//form[@action='/search']//div[@role='button' and (@aria-label='Borrar' or @aria-label='Delete')]")
    private ExtendedWebElement clearSearchinput;

    @FindBy(xpath = "//a[@class='gb_e']")
    private ExtendedWebElement googleApps;

    @FindBy(xpath = "//a[@class='pHiOh']")
    private ExtendedWebElement aboutGoogle;

    public Google(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchForm);
    }

    public SearchResultPage search(String subject){
        searchInput.type(subject);
        searchButton.click();
        return new SearchResultPage(driver);
    }

    public void writeAndDeleteInput(String subject){
        searchInput.type(subject);
        clearSearchinput.click();
        Assert.assertTrue(searchInput.getText().isEmpty());
    }

    public ExtendedWebElement getGoogleApps() {
        return googleApps;
    }

    public InfoPage getAboutGoogle() {
        aboutGoogle.click();
        return new InfoPage(driver);
    }
}