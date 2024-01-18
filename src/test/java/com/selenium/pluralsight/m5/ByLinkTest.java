package com.selenium.pluralsight.m5;


import com.selenium.pluralsight.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.selenium.pluralsight.Pages.HOME;

public class ByLinkTest {

    //OTHER RECOMMENDED WAY TO ACCESS A RESOURCE
    @Test
    public void byLinkText() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        driver.findElement(By.linkText("Savings")).click();
        driver.quit();
    }
}
