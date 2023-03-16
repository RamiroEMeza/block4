package com.solvd.laba.carina.demo.mobile.homework.gui.android.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
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

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = StopwatchPageBase.class)
public class StopwatchPage extends StopwatchPageBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "com.google.android.deskclock:id/tabs")
    private ClockTabs clockTabs;//Nav component

    @FindBy(id = "com.google.android.deskclock:id/stopwatch_time_text")
    private ExtendedWebElement timeCounter;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Start\"]")
    private ExtendedWebElement startStopwatch;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Pause\"]")
    private ExtendedWebElement stopStopwatch;

    @FindBy(xpath = "//android.widget.Button[@content-desc=\"Reset\"]")
    private ExtendedWebElement resetStopwatch;

    @FindBy(xpath = "//rk[@content-desc=\"Alarm\"]")
    private ExtendedWebElement alarmsBtn;

    public StopwatchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void runStopwatch() {
        startStopwatch.click();
    }

    @Override
    public void stopStopwatch() {
        stopStopwatch.click();
    }

    @Override
    public void resetStopwatch() {
        resetStopwatch.click();
    }

    @Override
    public boolean checkIfStopwatchStarted() {
        return timeCounter.getText().contains(":") || !timeCounter.getText().equals("0");
    }


    @Override
    public boolean isPageOpened() {
        return alarmsBtn.isElementPresent();
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
