package com.solvd.laba.carina.demo.gui.pages.homework;

import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.List;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.laba.carina.demo.gui.components.WeValuePrivacyAd;


public class Google extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//form[@action='/search']")
    private ExtendedWebElement searchForm;

    @FindBy(xpath = "//a[@class='gb_e']")
    private ExtendedWebElement googleApps;

    @FindBy(xpath = "//a[@class='pHiOh']")
    private ExtendedWebElement aboutGoogle;

    public Google(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(searchForm);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public SearchResultPage search(String subject){
        searchForm.findExtendedWebElement(By.name("q")).type(subject);
        searchForm.findExtendedWebElement(By.name("btnK")).click();
        return new SearchResultPage(driver);
    }

    public void luckySearch(String subject){
        searchForm.findExtendedWebElement(By.name("q")).type(subject);
        searchForm.findExtendedWebElement(By.name("btnI")).click();
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

    public ExtendedWebElement getGoogleApps() {
        return googleApps;
    }

    public InfoPage getAboutGoogle() {
        aboutGoogle.click();
        return new InfoPage(driver);
    }
}