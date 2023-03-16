package com.solvd.laba.mobile.homework;

import com.solvd.laba.carina.demo.mobile.homework.gui.common.AlarmsPageBase;
import com.solvd.laba.carina.demo.mobile.homework.gui.common.ClockPageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;


public class MobileTest implements IAbstractTest, IMobileUtils {

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

}
