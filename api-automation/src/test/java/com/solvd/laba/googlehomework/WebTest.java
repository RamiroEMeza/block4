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

    @DataProvider(name = "searchChangePage")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"Alone Again", "2"},
                {"Hotel california", "3"},
                {"colombia", "4"}
        };
    }

    @Test()
    @MethodOwner(owner = "ramiroMeza")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void writeAndClearSearchInput() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Page is not opened!");
        googleHomePage.writeAndDeleteInput(R.TESTDATA.get("search_example_one"));
    }

    @Test()
    @MethodOwner(owner = "ramiroMeza")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSearch() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Page is not opened!");

        SearchResultPage secondPage = googleHomePage.search(R.TESTDATA.get("search_example_one"));
        Assert.assertTrue(secondPage.isPageOpened(), "Page is not opened!");
        secondPage.getSearchItem().checkSearch(R.TESTDATA.get("search_example_one"));

        SearchResultPage thirdPage = secondPage.search(R.TESTDATA.get("search_example_two"));
        Assert.assertTrue(thirdPage.isPageOpened(), "Page is not opened!");
        thirdPage.getSearchItem().checkSearch(R.TESTDATA.get("search_example_two"));
    }

    @Test(dataProvider = "searchChangePage")
    @MethodOwner(owner = "ramiroMeza")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testSearchAndChangePage(String search, String page) {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Page is not opened!");

        SearchResultPage firstSearchResults = googleHomePage.search(search);
        Assert.assertTrue(firstSearchResults.isPageOpened(), "Page is not opened!");
        firstSearchResults.getSearchItem().checkSearch(search);

        SearchResultPage secondSearchResults = firstSearchResults.getPages().changePage(page);
        Assert.assertTrue(secondSearchResults.isPageOpened(), "Page is not opened!");
        secondSearchResults.getSearchItem().checkSearch(search);
        Assert.assertTrue((secondSearchResults.getPages().checkCorrectPageIsOpen(page) == null), "Correct page is not opened!");
    }

    @Test()
    @MethodOwner(owner = "ramiroMeza")
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
        Assert.assertTrue(infoPage.isPageOpened(), "Page is not opened!");
        infoPage.checkLinks();

    }

    @Test()
    @MethodOwner(owner = "ramiroMeza")
    @TestLabel(name = "feature", value = {"web", "acceptance"})
    public void testGoToFaq() {
        GoogleHomePage googleHomePage = new GoogleHomePage(getDriver());
        googleHomePage.open();
        Assert.assertTrue(googleHomePage.isPageOpened(), "Page is not opened!");

        TermsPolicyPage termsPolicyPage = googleHomePage.goToTermsPolicy();
        Assert.assertTrue(termsPolicyPage.isPageOpened(), "Page is not opened!");

        FaqPolicyPage faqPolicyPage = termsPolicyPage.getPoliciesNavigation().openFaq();
        Assert.assertTrue(faqPolicyPage.isPageOpened(), "Page is not opened!");
        Assert.assertTrue(faqPolicyPage.checkTextsDisplayed(), "Text is not displayed!");
    }


}
