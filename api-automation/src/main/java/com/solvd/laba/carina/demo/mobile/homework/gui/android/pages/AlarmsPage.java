package com.solvd.laba.carina.demo.mobile.homework.gui.android.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.laba.carina.demo.mobile.homework.gui.android.components.ClockTabs;
import com.solvd.laba.carina.demo.mobile.homework.gui.common.AlarmsPageBase;
import com.solvd.laba.carina.demo.mobile.homework.gui.common.ClockPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AlarmsPageBase.class)
public class AlarmsPage extends AlarmsPageBase {

    @FindBy(xpath = "//rk[@content-desc=\"Alarm\"]")
    private ExtendedWebElement alarmsBtn;

    @FindBy(id = "com.google.android.deskclock:id/tabs")
    private ClockTabs clockTabs;

    public AlarmsPage(WebDriver driver) {
        super(driver);
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
}
