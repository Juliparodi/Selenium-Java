package com.selenium.pluralsight.m5;

import com.selenium.pluralsight.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static com.selenium.pluralsight.Pages.HOME;

public class ByCssTest {

    WebDriver driver;

    @Test
    public void byCssSelector() {
        driver = DriverFactory.newDriver();
        driver.get(HOME);
        var datePicker = driver.findElement(By.cssSelector("input[type=date]"));
        var emailPicker = driver.findElement(By.cssSelector("input[type=email]"));

        datePicker.sendKeys("10/12/2023");
        emailPicker.sendKeys("juli@gmail.com");

        WebElement registerBtn = driver.findElement(By.id("register"));
        registerBtn.click();

        DemoHelper.pause();

    }

    @Test
    public void byCssSelector_2() {
        driver = DriverFactory.newDriver();
        driver.get(HOME);
        var checkbox = driver.findElement(By.cssSelector("[type=checkbox]:not(:checked)"));
        checkbox.click();

        DemoHelper.pause();

    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
