package com.solvd.laba.carina.demo.mobile.homework.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ClockPageBase extends AbstractPage implements INavigateInClock {

    public ClockPageBase(WebDriver driver) {
        super(driver);
    }

}
