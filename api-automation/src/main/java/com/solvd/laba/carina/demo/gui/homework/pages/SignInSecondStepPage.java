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

public class SignInSecondStepPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//form")
    private ExtendedWebElement form;

    @FindBy(xpath = "//div[@id='identifierNext']//button")
    private ExtendedWebElement nextbButton;

    public SignInSecondStepPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(form);
    }

    public GoogleHomePage checkIn(String password) {
        ExtendedWebElement passwordInput = form.findExtendedWebElement(By.xpath("//input[@name='password']"));
        passwordInput.type(password);
        nextbButton.click();
        return new GoogleHomePage(driver);
    }

}