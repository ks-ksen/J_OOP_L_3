package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

public class NavigationTest extends BaseTest {
    @Test
    void navigationPanelTest() {
        driver.get(BASE_URL + "/career");
        String header;


        WebElement careerNavItemButton = driver.findElement(By.cssSelector("nav > a[href='/career']"));

        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Карьера", header);


        driver.findElement(By.cssSelector("nav > a[href='/tests']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Тесты", header);


        driver.findElement(By.cssSelector("nav.gb-left-menu__nav .svg-icon.icon-courses")).click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        // Теперь не боимся что тест упадет
        driver.findElement(By.xpath("//div/div/button[*]")).click();

        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Курсы", header);

        driver.findElement(By.cssSelector("nav > a[href='/events']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Вебинары", header);

        driver.findElement(By.cssSelector("nav > a[href='/topics']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Форум", header);

        driver.findElement(By.cssSelector("nav > a[href='/posts']")).click();
        header = driver.findElement(By.className("gb-header__title")).getText();
        Assertions.assertEquals("Блог", header);
    }

}
