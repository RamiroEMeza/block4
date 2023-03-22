package com.solvd.laba.carina.demo.mobile.homework.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class StopwatchPageBase extends AbstractPage implements INavigateInClock {
    public StopwatchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void runStopwatch();

    public abstract void resetStopwatch();

    public abstract boolean checkIfStopwatchStarted();
}
