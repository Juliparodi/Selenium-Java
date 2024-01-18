package com.selenium.pluralsight.m5;

import com.selenium.pluralsight.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.selenium.pluralsight.Pages.HOME;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsTest {

    WebDriver driver;

    @Test
    public void relativeLocator() {
        driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement email = driver.findElement(By.id("email"));
        RelativeLocator.RelativeBy input = with(By.tagName("input"));

        WebElement datePicker = driver.findElement(input.toRightOf(email));
        System.out.println(datePicker.getAttribute("type"));

        WebElement firstName = driver.findElement(input.above(email));
        System.out.println(firstName.getAttribute("id"));
    }

    @AfterMethod
    void cleanUp() {
        driver.quit();
    }
}
