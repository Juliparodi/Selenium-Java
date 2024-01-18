package com.selenium.pluralsight.m9;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static helper.Pages.LOANS;
import static wait.WaitingUtils.waitUntilVisible;

public class RefactorSetupCleanup2  extends BaseTestClass {

    @Test
    public void refactoredTestDemo() {
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("500");

        var message = waitUntilVisible(driver, By.id("result"), 6);
        assertEquals(message.getText(), "You will pays us back 1000");
    }

    @Test
    public void refactoredTestDemoDuplicate() {
        driver.get(LOANS);
        driver.findElement(By.id("borrow")).sendKeys("100");

        var message = waitUntilVisible(driver, By.id("result"), 6);
        assertEquals(message.getText(), "You will pays us back 200");
    }
}
