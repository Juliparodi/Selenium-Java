package com.selenium.pluralsight.m4;

import com.selenium.pluralsight.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static com.selenium.pluralsight.Pages.HOME;

public class AttributesTest {

    @Test
    public void isEnabledTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement textArea = driver.findElement(By.id("textarea"));
        Assert.assertFalse(textArea.isEnabled());

        if (textArea.isEnabled()) {
            textArea.sendKeys("test");
        }

        DemoHelper.pause();
        driver.quit();
    }

    @Test
    public void isDisplayedTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement feedback = driver.findElement(By.className("invalid-feedback"));
        Assert.assertFalse(feedback.isDisplayed());

        driver.findElement(By.id("register")).click();
        Assert.assertTrue(feedback.isDisplayed());

        driver.quit();
    }

    @Test
    public void multipleElementsTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        List<WebElement> feedback = driver.findElements(By.className("invalid-feedback"));

        print(feedback.get(0).getText());
        print(feedback.get(1).getText());

        driver.findElement(By.id("register")).click();
        print(feedback.get(0).getText());
        print(feedback.get(1).getText());

        driver.quit();
    }

    private void print(String text) {
        System.out.println("Feedback: " + text);
    }
}