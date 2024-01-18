package com.selenium.pluralsight.m5;

import com.selenium.pluralsight.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.selenium.pluralsight.Pages.HOME;
import static com.selenium.pluralsight.Pages.SAVINGS;

public class ByIdClassTagTest {

    WebDriver driver;

    //BEST RECOMMENDED WAY TO ACCESS A RESOURCE
    @Test
    public void byId() {
        driver = DriverFactory.newDriver();
        driver.get(HOME);

        driver.findElement(By.id("register")).click();

        //NOT recommended to use byClassName if there are multiple classes in the page
        driver.findElement(By.className("invalid-feedback"));
    }

    //For very simple cases
    @Test
    public void byTagName() {
        driver = DriverFactory.newDriver();
        driver.get(SAVINGS);

        var table = driver.findElement(By.id("rates"));
        var sameTable = driver.findElement(By.tagName("table"));

        System.out.println(table.getText());
        System.out.println(sameTable.getText());
    }
}
