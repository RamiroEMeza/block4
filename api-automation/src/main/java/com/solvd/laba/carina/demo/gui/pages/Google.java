package com.solvd.laba.carina.demo.gui.pages;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.laba.carina.demo.gui.components.WeValuePrivacyAd;


public class Google extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//input[@class='gLFyf']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//input[@class='gNO89b']")//RNmpXc
    private ExtendedWebElement buttonToSearch;//

    @FindBy(xpath = "//input[@class='RNmpXc']")
    private ExtendedWebElement buttonToIFeelingLucky;//

    @FindBy(xpath = "//a[@class='gb_e']")
    private ExtendedWebElement googleApps;

    public Google(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(searchInput);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public void search(String subject){
        this.searchInput.type(subject);
        this.buttonToSearch.click();
    }

    public void luckySearch(String subject){
        this.searchInput.type(subject);
        this.buttonToIFeelingLucky.click();
    }

    public void goYoutube() {
        this.googleApps.click();
        new WebDriverWait(this.getDriver(), Duration.ofSeconds(2));
        WebElement youtubeLink = this.getDriver().findElement(By.xpath("//a[@class='tX9u1b']"));
        youtubeLink.click();
    }

    public WeValuePrivacyAd getWeValuePrivacyAd() {
        return new WeValuePrivacyAd(driver);
    }
}