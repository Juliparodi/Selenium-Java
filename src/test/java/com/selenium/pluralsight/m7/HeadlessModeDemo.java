package com.selenium.pluralsight.m7;

import com.selenium.pluralsight.DemoHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import static com.selenium.pluralsight.Pages.HOME;

public class HeadlessModeDemo {

    @Test
    public void headlessDemo() {

        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        options.addArguments("headless=true");


        WebDriver driver = new ChromeDriver(options);
        driver.get(HOME);

        WebElement button = driver.findElement(By.id("register"));
        System.out.println(button.getText()); //proves that we loaded the page

        button.click();
        driver.findElement(By.id("clear")).click();

        DemoHelper.pause();
        driver.quit();
    }
}
