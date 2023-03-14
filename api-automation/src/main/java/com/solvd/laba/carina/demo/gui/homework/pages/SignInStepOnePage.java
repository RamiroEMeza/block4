package com.solvd.laba.carina.demo.gui.homework.pages;

import java.lang.invoke.MethodHandles;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class SignInStepOnePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//form")
    private ExtendedWebElement form;

    @FindBy(xpath = "//div[@id='identifierNext']//button")
    private ExtendedWebElement nextbButton;

    public SignInStepOnePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(form);
    }

    public void checkIn(String email) {
        ExtendedWebElement emailInput = form.findExtendedWebElement(By.xpath("//input[@name='identifier']"));
        emailInput.type(email);
//        nextbButton.click();
//        return new SignInSecondStepPage(driver);
    }

    public void checkDataProvided(String email) {
        ExtendedWebElement emailInput = form.findExtendedWebElement(By.xpath("//input[@name='identifier']"));
        Assert.assertEquals(email, emailInput.getAttribute("value"), "Data Provided is Corrupted!");
    }
}
