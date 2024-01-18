package com.selenium.pluralsight.m7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.logging.Level;

import static com.selenium.pluralsight.Pages.HOME;

public class MobileAutomationTest {

    WebDriver driver;

    @Test
    public void deviceEmulation() {

        Map<String, String> mobileEmulation = Map.of("deviceName", "Nexus 5");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", mobileEmulation);

        //options.setScriptTimeout()

        WebDriver driver = new ChromeDriver(options);
        driver.get(HOME);
        driver.findElement(By.id("register")).click();
    }

    @Test
    public void deviceEmulationLogCapture() {

        LoggingPreferences logs = new LoggingPreferences();
        logs.enable(LogType.BROWSER, Level.ALL);

        ChromeOptions options = new ChromeOptions();
        options.setCapability(ChromeOptions.LOGGING_PREFS, logs);
        driver = new ChromeDriver(options);
        driver.get(HOME);
        driver.findElement(By.id("register")).click();

        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);

        Assert.assertFalse(browserLogs.getAll().isEmpty());

        browserLogs.forEach(System.out::println);

        browserLogs.forEach(logEntry -> System.out.println(logEntry.getLevel() + " " + logEntry.getMessage()));

        browserLogs.forEach(this::checkNoError);
    }

    private void checkNoError(LogEntry logEntry) {
        Assert.assertNotEquals(logEntry.getLevel().getName(), "SEVERE");
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
