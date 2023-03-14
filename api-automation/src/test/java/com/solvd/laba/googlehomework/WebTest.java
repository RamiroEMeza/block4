package com.solvd.laba.googlehomework;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.laba.carina.demo.gui.homework.pages.*;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "CheckInData")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"testcheckin2023@gmail.com", "chairdesk56"},
        };
    }

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

        SearchResultPage firstSearchResults = googleHomePage.search(R.TESTDATA.get("search_example_one"));
        Assert.assertTrue(firstSearchResults.isPageOpened(), "Page is not opened!");
        firstSearchResults.checkSearch(R.TESTDATA.get("search_example_one"));

        SearchResultPage secondSearchResults = firstSearchResults.changePage(R.TESTDATA.get("change_to_result_page"));
        Assert.assertTrue(secondSearchResults.isPageOpened(), "Page is not opened!");
        secondSearchResults.checkSearch(R.TESTDATA.get("search_example_one"));
        secondSearchResults.checkCorrectPageIsOpen(R.TESTDATA.get("change_to_result_page"));
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testAboutGoogle() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Page is not opened!");

        InfoPage infoPage = googleHomePage.getAboutGoogle();
        Assert.assertTrue(infoPage.isPageOpened(), "Page is not opened!");
        infoPage.checkLinks();

        ProductPage productPage = infoPage.getAboutGoogleNavigation().openProductPage();
        Assert.assertTrue(productPage.isPageOpened(), "Page is not opened!");
        productPage.checkGoogleProductsList();

        CommitmentsPage commitmentsPage = productPage.getAboutGoogleNavigation().openCommitmentsPage();
        Assert.assertTrue(commitmentsPage.isPageOpened(), "Page is not opened!");
        commitmentsPage.checkReports();
        commitmentsPage.checkGoogleCommitments();

        StoriesPage storiesPage = commitmentsPage.getAboutGoogleNavigation().openStoriesPage();
        Assert.assertTrue(storiesPage.isPageOpened(), "Page is not opened!");

        infoPage = storiesPage.getAboutGoogleNavigation().openInfoPage();

    }

    @Test(dataProvider = "CheckInData")
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testCheckIn(String email, String password) {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Page is not opened!");

        SignInStepOnePage signInStepOnePage = googleHomePage.goToSignIn();

        signInStepOnePage.checkIn(email);
        signInStepOnePage.checkDataProvided(email);

    }


}
