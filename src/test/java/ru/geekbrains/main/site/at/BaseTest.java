package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected WebDriver driver;
    protected final String BASE_URL = "https://geekbrains.ru";

    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ксения\\Desktop\\mainsiteat\\src\\test\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
