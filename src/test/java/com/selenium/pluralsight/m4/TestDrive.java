package com.selenium.pluralsight.m4;

import com.selenium.pluralsight.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.selenium.pluralsight.Pages.HOME;

public class TestDrive {

    private static final String PREFIX = "file:///" + System.getProperty("user.dir") + "\\src\\web\\";

    @Test
    public void basicNavigationTest() {
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedrivers");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get(PREFIX + "index.html");

        DemoHelper.pause();
        driver.get(PREFIX + "savings.html");

        DemoHelper.pause();
        driver.navigate().back();

        DemoHelper.pause();
        driver.navigate().forward();

        driver.navigate().refresh();

        driver.quit();
    }

    @Test
    public void basicNavigationTestRefactored() {
        WebDriver driver = DriverFactory.newDriver();

        driver.get(String.valueOf(HOME));
    }


}
