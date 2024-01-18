package com.selenium.pluralsight.m4;

import com.selenium.pluralsight.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static com.selenium.pluralsight.Pages.HOME;

public class TypingTest {

    @Test
    public void typingTest() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement first = driver.findElement(By.id("firstName"));
        WebElement last = driver.findElement(By.id("lastName"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement dob = driver.findElement(By.id("dob"));

        first.sendKeys("Sofia");
        last.sendKeys("Diaz");
        email.sendKeys("sofia@email.com");

        DemoHelper.pause();
        email.clear();
        email.sendKeys("sofia@email.com");
        dob.sendKeys("22/03/2022");

        DemoHelper.pause();
        driver.quit();

    }

    @Test
    public void moreClicking() {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(HOME);

        WebElement checkbox = driver.findElement(By.id("heard-about"));
        Actions actions = new Actions(driver);

        actions.doubleClick(checkbox).perform();
        actions.contextClick(checkbox).perform();

        DemoHelper.pause();

        driver.quit();
    }
}
