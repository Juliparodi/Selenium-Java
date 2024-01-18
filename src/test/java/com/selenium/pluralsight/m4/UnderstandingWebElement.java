package com.selenium.pluralsight.m4;

import com.selenium.pluralsight.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static com.selenium.pluralsight.Pages.HOME;

public class UnderstandingWebElement {

    @Test
    public void webElementTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement input = driver.findElement(By.id("firstName"));
        System.out.println(input.isDisplayed());

        WebElement button = driver.findElement(By.id("register"));
        System.out.println(button.getText());

        button.click();
        button.sendKeys("some input"); //doesn't make sense

        driver.quit();
    }
}
