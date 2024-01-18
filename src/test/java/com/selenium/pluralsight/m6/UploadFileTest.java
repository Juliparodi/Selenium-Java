package com.selenium.pluralsight.m6;

import com.selenium.pluralsight.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.selenium.pluralsight.Pages.LOANS;

public class UploadFileTest {

    @Test
    void uploadFile() throws IOException {
        WebDriver driver = DriverFactory.newDriver();
        driver.get(LOANS);

        WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));

        Path path = Files.createTempFile("file", ".txt");
        String fileName = path.toAbsolutePath().toString();
        System.out.println(fileName);

        fileInput.sendKeys(fileName);

        DemoHelper.pause();
        driver.quit();
        path.toFile().deleteOnExit();
    }
}
