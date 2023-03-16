package com.solvd.laba.carina.demo.mobile.homework.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AlarmsPageBase extends AbstractPage implements INavigateInClock {
    public AlarmsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void addAlarm(String hour, String minute);

    public abstract boolean searchStoredAlarm(String hour, String minute);
}
