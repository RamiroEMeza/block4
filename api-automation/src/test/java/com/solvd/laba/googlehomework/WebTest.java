package com.solvd.laba.googlehomework;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.laba.carina.demo.gui.components.FooterMenu;
import com.solvd.laba.carina.demo.gui.components.NewsItem;
import com.solvd.laba.carina.demo.gui.components.compare.ModelSpecs;
import com.solvd.laba.carina.demo.gui.components.compare.ModelSpecs.SpecType;
import com.solvd.laba.carina.demo.gui.pages.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.List;

/**
 * This sample shows how create Web test.
 *
 * @author qpsdemo
 */
public class WebTest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testDesktopWidth() {
        Google google = new Google(getDriver());
        google.open();
        Assert.assertTrue(google.isPageOpened(), "Home page is not opened!");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(String.valueOf(google.getDevice().getDeviceType()), "DESKTOP");
        softAssert.assertEquals(String.valueOf(getDriver().manage().window().getSize().getWidth()>=1024), "true");
        softAssert.assertAll();
    }
    
    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSearch() {
        Google google = new Google(getDriver());
        google.open();
        Assert.assertTrue(google.isPageOpened(), "Home page is not opened!");
        final String searchQ = "Never gonna give you up";
        google.search(searchQ);
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testLuckySearch() {
        Google google = new Google(getDriver());
        google.open();
        Assert.assertTrue(google.isPageOpened(), "Home page is not opened!");
        final String searchQ = "Never gonna give you up";
        google.luckySearch(searchQ);
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSearchAndChangePage(){
        Google google = new Google(getDriver());
        google.open();
        Assert.assertTrue(google.isPageOpened(), "Home page is not opened!");
        final String searchQ = "Never gonna give you up";
        google.search(searchQ);

        WebElement secondPage = google.getDriver().findElement(By.xpath("//a[@class='fl']"));
        secondPage.click();
    }


    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testGoToProducts(){
        Google google = new Google(getDriver());
        google.open();
        Assert.assertTrue(google.isPageOpened(), "Home page is not opened!");
        google.getAboutGoogle().click();//glue-header__link

        List<WebElement> menu = google.getDriver().findElements(By.xpath("//a[@class='glue-header__link']"));
        for (WebElement element: menu) {
            if (element.getText().contains("Produc")) {
                element.click();
                break;
            }
        }
    }

}
