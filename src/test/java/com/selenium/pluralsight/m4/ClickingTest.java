package com.selenium.pluralsight.m4;

import com.selenium.pluralsight.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.selenium.pluralsight.Pages.HOME;

public class ClickingTest {

    @Test
    public void clickingTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement first = driver.findElement(By.id("firstName"));
        WebElement checkBox = driver.findElement(By.id("heard-about"));
        WebElement registerBtn = driver.findElement(By.id("register"));

        checkBox.click();
        registerBtn.click();
        DemoHelper.pause();

        driver.quit();

    }
}
