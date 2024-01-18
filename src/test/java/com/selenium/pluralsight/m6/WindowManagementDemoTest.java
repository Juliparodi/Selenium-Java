package com.selenium.pluralsight.m6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.selenium.pluralsight.Pages.HOME;
import static com.selenium.pluralsight.Pages.SAVINGS;

public class WindowManagementDemoTest {

    @Test
    public void tabsAndWindowsDemo() {
        WebDriver driver = new ChromeDriver();
        driver.get(HOME);

        String firstTab = driver.getWindowHandle();


        DemoHelper.pause();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(SAVINGS);
        Assert.assertEquals(driver.getWindowHandles().size(), 2);

        driver.switchTo().window(firstTab);
        DemoHelper.pause();
        driver.close();
        Assert.assertEquals(driver.getWindowHandles().size(), 1);

        driver.quit();
    }
}
