package selenium;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest extends WebDriverSettings {

    @Test
    public void userLogin() throws InterruptedException {
        driver.get("https://yandex.ru");
        String title = driver.getTitle();
        Assert.assertTrue("Яндекс".equals(title));

        WebElement mailBlock = driver.findElement(By.className("desk-notif-card__card"));
        mailBlock.findElement(By.className("desk-notif-card__login-enter-expanded")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));

        // Ввод логина и пароля
        driver.findElement(By.name("login")).sendKeys("onetesto");
        driver.findElement(By.name("passwd")).sendKeys("1234Qs!");

        //Вход
        driver.findElement(By.className("passport-Button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mail-User-Name")));
        WebElement userName = driver.findElement(By.className("mail-User-Name"));
        System.out.println("Имя пользователя: " + userName.getText());
        userName.click();

        WebElement userBar = driver.findElement(By.className("_nb-popup-content"));
        userBar.findElement(By.xpath("//*[text()=\"Выйти из сервисов Яндекса\"]")).click();
    }

}