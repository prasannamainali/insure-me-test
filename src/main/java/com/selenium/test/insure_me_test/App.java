package com.selenium.test.insure_me_test;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {
    public static void main(String[] args) {
        
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        
        driver.get("http://54.89.80.249:8081/contact.html");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.id("inputName")).sendKeys("First Name");
        driver.findElement(By.id("inputNumber")).sendKeys("1234567890");
        driver.findElement(By.id("inputMail")).sendKeys("mainaliprassnna@test.com");
        driver.findElement(By.id("inputMessage")).sendKeys("Hi There!");
        driver.findElement(By.id("my-button")).click();
        // Wait for the message using different locators
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            WebElement response = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("response")));
            System.out.println("Message Found: " + response.getText());

            if (response.getText().equalsIgnoreCase("Message Sent")) {
                System.out.println("Test case passed");
            } else {
                System.out.println("Test case failed: Incorrect text - " + response.getText());
            }
        } catch (TimeoutException e) {
            System.out.println("Test failed: Message element did not appear in time.");
        }

        driver.quit();
    }
}
