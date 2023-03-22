package com.solvd.laba.carina.demo.mobile.homework.gui.android.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.solvd.laba.carina.demo.mobile.homework.gui.android.components.ClockTabs;
import com.solvd.laba.carina.demo.mobile.homework.gui.common.AlarmsPageBase;
import com.solvd.laba.carina.demo.mobile.homework.gui.common.ClockPageBase;
import com.solvd.laba.carina.demo.mobile.homework.gui.common.StopwatchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AlarmsPageBase.class)
public class AlarmsPage extends AlarmsPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//rk[@content-desc=\"Alarm\"]")
    private ExtendedWebElement alarmsBtn;//Nav btn

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Add alarm\"]")
    private ExtendedWebElement addAlarmBtn;// "+" btn

    @FindBy(id = "com.google.android.deskclock:id/tabs")
    private ClockTabs clockTabs;//Nav component
    @FindBy(xpath = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"%s\"]")
    private ExtendedWebElement clockBtn;//clock time selector

    @FindBy(xpath = "//android.widget.TextView[contains(@content-desc, \"%s\")]")
    private ExtendedWebElement timeStoredAlarm;//Alarms time in display

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement okAddAlarm;

    public AlarmsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return alarmsBtn.isElementPresent();
    }

    public void addAlarm(String hour, String minute) {
        addAlarmBtn.click();
        clockBtn.format(hour).click();
        clockBtn.format(minute).click();
        okAddAlarm.click();
    }

    public boolean searchStoredAlarm(String hour, String minute) {
        ExtendedWebElement alarm = timeStoredAlarm.format(hour + ":" + minute);
        return alarm.isElementPresent();
    }

    @Override
    public AlarmsPageBase goToAlarms() {
        return clockTabs.goToAlarms();
    }

    @Override
    public ClockPageBase goToClock() {
        return clockTabs.goToClock();
    }

    @Override
    public StopwatchPageBase goToStopwatch() {
        return clockTabs.goToStopwatch();
    }
}
