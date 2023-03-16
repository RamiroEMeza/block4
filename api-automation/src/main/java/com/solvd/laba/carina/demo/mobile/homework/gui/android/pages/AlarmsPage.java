package com.solvd.laba.carina.demo.mobile.homework.gui.android.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.laba.carina.demo.mobile.homework.gui.android.components.ClockTabs;
import com.solvd.laba.carina.demo.mobile.homework.gui.common.AlarmsPageBase;
import com.solvd.laba.carina.demo.mobile.homework.gui.common.ClockPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AlarmsPageBase.class)
public class AlarmsPage extends AlarmsPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public final String Q_ADD_ALARM = "//android.widget.RadialTimePickerView.RadialPickerTouchHelper[@content-desc=\"VAR\"]";

    public final String Q_CHECK_STORED_ALARM = "//android.widget.TextView[@content-desc=\"HH:MM AM\"]";

    @FindBy(xpath = "//rk[@content-desc=\"Alarm\"]")
    private ExtendedWebElement alarmsBtn;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Add alarm\"]")
    private ExtendedWebElement addAlarmBtn;

    @FindBy(id = "android:id/timePicker")
    private ExtendedWebElement timeSelector;

    @FindBy(id = "com.google.android.deskclock:id/alarm_recycler_view")
    private ExtendedWebElement storedAlarms;

    @FindBy(id = "com.google.android.deskclock:id/tabs")
    private ClockTabs clockTabs;

    public AlarmsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return alarmsBtn.isElementPresent();
    }

    public void addAlarm(String hour, String minute) {
        addAlarmBtn.click();
        timeSelector.findExtendedWebElement(By.xpath(Q_ADD_ALARM.replace("VAR", hour))).click();
        timeSelector.findExtendedWebElement(By.xpath(Q_ADD_ALARM.replace("VAR", minute))).click();
        timeSelector.findExtendedWebElement(By.id("android:id/button1")).click();
    }

    public boolean searchStoredAlarm(String hour, String minute) {
        ExtendedWebElement alarm = storedAlarms.findExtendedWebElement(By.xpath(Q_CHECK_STORED_ALARM.replace("HH", hour).replace("MM", minute)));
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
}
