package com.solvd.laba.googlehomework;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.laba.carina.demo.gui.pages.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
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
        Assert.assertTrue(google.isPageOpened(), R.TESTDATA.get("not_opened"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(String.valueOf(google.getDevice().getDeviceType()), R.TESTDATA.get("desktop"));
        softAssert.assertEquals(String.valueOf(getDriver().manage().window().getSize().getWidth()>=R.TESTDATA.getInt("desktop_with")), "true");
        softAssert.assertAll();
    }
    
    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSearch() {
        Google google = new Google(getDriver());
        google.open();
        Assert.assertTrue(google.isPageOpened(), R.TESTDATA.get("not_opened"));
        google.search(R.TESTDATA.get("search_example_one"));
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testLuckySearch() {
        Google google = new Google(getDriver());
        google.open();
        Assert.assertTrue(google.isPageOpened(), R.TESTDATA.get("not_opened"));
        google.luckySearch(R.TESTDATA.get("search_example_one"));
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSearchAndChangePage(){
        Google google = new Google(getDriver());
        google.open();
        Assert.assertTrue(google.isPageOpened(), R.TESTDATA.get("not_opened"));
        google.search(R.TESTDATA.get("search_example_one"));

        WebElement secondPage = google.getDriver().findElement(By.xpath("//a[@class='fl']"));
        secondPage.click();
    }


    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testGoToProducts(){
        Google google = new Google(getDriver());
        google.open();
        Assert.assertTrue(google.isPageOpened(), R.TESTDATA.get("not_opened"));
        google.getAboutGoogle().click();//glue-header__link

        List<WebElement> menu = google.getDriver().findElements(By.xpath("//a[@class='glue-header__link']"));
        for (WebElement element: menu) {
            if (element.getText().contains(R.TESTDATA.get("products_section"))) {
                element.click();
                break;
            }
        }
    }

}
