package com.solvd.laba.googlehomework;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.laba.carina.demo.gui.pages.homework.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;

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
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Page is not opened!");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(String.valueOf(googleHomePage.getDevice().getDeviceType()), R.TESTDATA.get("desktop"));
        softAssert.assertEquals(String.valueOf(getDriver().manage().window().getSize().getWidth() >= R.TESTDATA.getInt("desktop_with")), "true");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void writeAndClearSearchInput() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Page is not opened!");
        googleHomePage.writeAndDeleteInput(R.TESTDATA.get("search_example_one"));
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSearch() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Page is not opened!");

        SearchResultPage secondPage = googleHomePage.search(R.TESTDATA.get("search_example_one"));
        Assert.assertTrue(secondPage.isPageOpened(), "Page is not opened!");
        secondPage.checkSearch(R.TESTDATA.get("search_example_one"));

        SearchResultPage thirdPage = secondPage.search(R.TESTDATA.get("search_example_two"));
        Assert.assertTrue(thirdPage.isPageOpened(), "Page is not opened!");
        thirdPage.checkSearch(R.TESTDATA.get("search_example_two"));
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSearchAndChangePage() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Page is not opened!");


        SearchResultPage secondPage = googleHomePage.search(R.TESTDATA.get("search_example_one"));
        Assert.assertTrue(secondPage.isPageOpened(), "Page is not opened!");
        secondPage.checkSearch(R.TESTDATA.get("search_example_one"));
        secondPage.changePage(2);
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testGoToProducts() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Page is not opened!");

        InfoPage infoPage = googleHomePage.getAboutGoogle();
        infoPage.assertPageOpened();

        ProductPage productPage = infoPage.getAboutGoogleNavigation().openProductPage();
        productPage.assertPageOpened();
        productPage.checkGoogleProductsList();

        CommitmentsPage commitmentsPage = productPage.getAboutGoogleNavigation().openCommitmentsPage();
        commitmentsPage.assertPageOpened();

        StoriesPage storiesPage = commitmentsPage.getAboutGoogleNavigation().openStoriesPage();
        storiesPage.assertPageOpened();

        infoPage = storiesPage.getAboutGoogleNavigation().openInfoPage();

    }

}
