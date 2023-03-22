package com.solvd.laba.mobile.homework;

import com.solvd.laba.carina.demo.mobile.homework.gui.common.AlarmsPageBase;
import com.solvd.laba.carina.demo.mobile.homework.gui.common.ClockPageBase;
import com.solvd.laba.carina.demo.mobile.homework.gui.common.StopwatchPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;


public class MobileTest implements IAbstractTest, IMobileUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testCreateAlarm() {
        ClockPageBase clockPage = initPage(getDriver(), ClockPageBase.class);
        Assert.assertTrue(clockPage.isPageOpened(), "Clock page isn't opened!");
        AlarmsPageBase alarmsPage = clockPage.goToAlarms();
        Assert.assertTrue(alarmsPage.isPageOpened(), "Clock page isn't opened!");
        alarmsPage.addAlarm(R.TESTDATA.get("alarm_hour"), R.TESTDATA.get("alarm_minute"));
        Assert.assertTrue(alarmsPage.searchStoredAlarm(R.TESTDATA.get("alarm_hour"), R.TESTDATA.get("alarm_minute")), "Alarm was not registered!");
    }

    @Test()
    @MethodOwner(owner = "qpsdemo")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testRunStopwatch() {
        ClockPageBase clockPage = initPage(getDriver(), ClockPageBase.class);
        Assert.assertTrue(clockPage.isPageOpened(), "Clock page isn't opened!");
        StopwatchPageBase stopwatchPageBase = clockPage.goToStopwatch();
        Assert.assertTrue(stopwatchPageBase.isPageOpened(), "Clock page isn't opened!");
        stopwatchPageBase.runStopwatch();
        //Assert.assertTrue(stopwatchPageBase.checkIfStopwatchStarted(), "Stopwatch didn't start!");
        stopwatchPageBase.resetStopwatch();
        //Assert.assertFalse(stopwatchPageBase.checkIfStopwatchStarted(), "Stopwatch didn't restart!");
    }

}
