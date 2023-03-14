package com.solvd.laba.carina.demo.gui.homework.pages;

import java.lang.invoke.MethodHandles;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.testng.Assert;


public class GoogleHomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[@name='q']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//input[@name='btnK' and @role='button']")
    private ExtendedWebElement searchButton;

    @FindBy(xpath = "//form//div[@role='button' and (@aria-label='Delete' or @aria-label='Borrar')]")
    private ExtendedWebElement clearSearchInput;

    @FindBy(xpath = "//a[@class='pHiOh']")
    private ExtendedWebElement aboutGoogle;

    @FindBy(xpath = "//div//a[contains(@href, 'accounts.google')]")
    private ExtendedWebElement signIn;

    public GoogleHomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchInput);
    }

    public SearchResultPage search(String subject) {
        searchInput.type(subject);
        searchButton.click();
        return new SearchResultPage(driver);
    }

    public void writeAndDeleteInput(String subject) {
        searchInput.type(subject);
        clearSearchInput.click();
        Assert.assertTrue(searchInput.getText().isEmpty());
    }

    public InfoPage getAboutGoogle() {
        aboutGoogle.click();
        return new InfoPage(driver);
    }

    public SignInStepOnePage goToSignIn() {
        signIn.click();
        return new SignInStepOnePage(driver);
    }
}