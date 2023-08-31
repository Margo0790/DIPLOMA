import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.json.JSONException;
import io.qameta.allure.*;

public class UITest {

    @Attachment("Итог операции")
    public byte[] getNotificationTextAttachment(String text) {
        return text.getBytes();
    }

    @Test
    public void testLoginPage() {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080");

        By buttonSelector = By.cssSelector(".button.button_size_m.button_theme_alfa-on-white");
        WebElement button = driver.findElement(buttonSelector);
        button.click();

        By inputSelector1 = By.cssSelector(".input_size_m .input__control");
        WebElement inputElement1 = driver.findElement(inputSelector1);

        // Вводим данные в первое поле ввода
        inputElement1.sendKeys("4444 4444 4444 4441");

        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement inputElement2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input")));
        inputElement2.sendKeys("09");

        WebElement inputElement3 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > form > fieldset > div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input")));
        inputElement3.sendKeys("23");

        WebElement inputElement4 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input")));
        inputElement4.sendKeys("ИВАН");

        WebElement inputElement5 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#root > div > form > fieldset > div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__box > input")));
        inputElement5.sendKeys("999");

        By buttonSelector2 = By.cssSelector("#root > div > form > fieldset > div:nth-child(4) > button");
        WebElement button2 = driver.findElement(buttonSelector2);
        button2.click();

//        // Ожидание и получение текста всплывающего окна
//        By notificationSelector = By.cssSelector(".notification.notification_visible.notification_status_ok.notification_has-closer.notification_stick-to_right.notification_theme_alfa-on-white");
//        WebDriverWait waitNotification = new WebDriverWait(driver, 10);
//        WebElement notificationElement = waitNotification.until(ExpectedConditions.presenceOfElementLocated(notificationSelector));




//        // Выводим текст в консоль
//        System.out.println("Итог операции: " + notificationText);

        // Выводим значения введенных данных в консоль
        System.out.println("Номер карты: " + inputElement1.getAttribute("value"));
        System.out.println("Месяц: " + inputElement2.getAttribute("value"));
        System.out.println("Год: " + inputElement3.getAttribute("value"));
        System.out.println("Имя владельца: " + inputElement4.getAttribute("value"));
        System.out.println("CVV: " + inputElement5.getAttribute("value"));




        // Закрываем браузер
        driver.quit();



    }
}
