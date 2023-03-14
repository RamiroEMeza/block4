package com.solvd.laba.carina.demo.gui.homework.dataprovider;

import org.testng.annotations.DataProvider;

public class CheckInProvider {

    @DataProvider(name = "CheckInData")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"notanaccount@gmail.com", "notapassword"},
                {"testcheckin2023", "chairdesk56"},
        };
    }

}
