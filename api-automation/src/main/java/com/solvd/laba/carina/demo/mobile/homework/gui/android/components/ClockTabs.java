package com.solvd.laba.carina.demo.mobile.homework.gui.android.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.laba.carina.demo.mobile.homework.gui.android.pages.AlarmsPage;
import com.solvd.laba.carina.demo.mobile.homework.gui.android.pages.ClockPage;
import com.solvd.laba.carina.demo.mobile.homework.gui.android.pages.StopwatchPage;
import com.solvd.laba.carina.demo.mobile.homework.gui.common.AlarmsPageBase;
import com.solvd.laba.carina.demo.mobile.homework.gui.common.ClockPageBase;
import com.solvd.laba.carina.demo.mobile.homework.gui.common.StopwatchPageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ClockTabs extends AbstractUIObject {

    @FindBy(xpath = "//rk[@content-desc=\"Alarm\"]")
    private ExtendedWebElement alarmBtn;
    @FindBy(xpath = "//rk[@content-desc=\"Clock\"]")
    private ExtendedWebElement clockBtn;

    @FindBy(xpath = "//rk[@content-desc=\"Timer\"]")
    private ExtendedWebElement timmerBtn;

    @FindBy(xpath = "//rk[@content-desc=\"Stopwatch\"]")
    private ExtendedWebElement stopwatchBtn;

    public ClockTabs(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public AlarmsPageBase goToAlarms() {
        alarmBtn.click();
        return new AlarmsPage(driver);
    }

    public ClockPageBase goToClock() {
        clockBtn.click();
        return new ClockPage(driver);
    }

    public StopwatchPageBase goToStopwatch() {
        stopwatchBtn.click();
        return new StopwatchPage(driver);
    }
}
