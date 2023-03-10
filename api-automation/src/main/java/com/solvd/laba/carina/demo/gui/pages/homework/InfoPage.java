package com.solvd.laba.carina.demo.gui.pages.homework;
import java.lang.invoke.MethodHandles;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
public class InfoPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//ul[@id='list-1']")
    private ExtendedWebElement pageNavigation;

    public InfoPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(pageNavigation);
    }

    public ProductPage goToProduct() {
        driver.findElement(By.xpath("//a[contains(text(), 'Prod')]")).click();
        return new ProductPage(driver);
    }
}
