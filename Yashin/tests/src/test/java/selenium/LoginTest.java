package selenium;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver","C:\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/");
    }

    @Test
    public void userLogin() {
        WebElement button = driver.findElement(By.id("login"));
        button.click();
        WebElement loginInput = driver.findElement(By.id("login"));
        loginInput.sendKeys("Alex");
        WebElement passInput = driver.findElement(By.id("pass"));
        passInput.sendKeys("1111");
        WebElement sendButton = driver.findElement(By.id("sendForm"));
        sendButton.click();
    }

}
