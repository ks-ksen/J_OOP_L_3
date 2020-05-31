package ru.geekbrains.main.site.at;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest extends BaseTest {
    @Test
    void searchJavaTest() {

        driver.get(BASE_URL + "/courses");


        WebElement searchButton = driver.findElement(By.cssSelector("ul > li > .show-search-form"));
        searchButton.click();

        WebElement searchInput = driver.findElement(By.cssSelector(".search-panel__search-field"));
        searchInput.sendKeys("java");

        WebDriverWait wait = new WebDriverWait(driver, 15);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.search-page-tabs")));

        WebElement professionsTab = driver
                .findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='professions']"));

        Assertions.assertTrue(professionsTab.isDisplayed());

        WebElement coursesTab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='courses']"));
        WebElement webinarsTab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='webinars']"));
        WebElement blogsTab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='blogs']"));
        WebElement forumsTab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='forums']"));
        WebElement testsTab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='tests']"));
        WebElement companiesTab = driver.findElement(By.cssSelector("ul.search-page-tabs > li > a[data-tab='companies']"));

        Assertions.assertTrue(coursesTab.isDisplayed());
        Assertions.assertTrue(webinarsTab.isDisplayed());
        Assertions.assertTrue(blogsTab.isDisplayed());
        Assertions.assertTrue(forumsTab.isDisplayed());
        Assertions.assertTrue(testsTab.isDisplayed());
        Assertions.assertTrue(companiesTab.isDisplayed());


        WebElement professions = driver.findElement(By
                .cssSelector("ul.search-page-tabs a[data-tab='professions'] > span"));
        Assertions.assertTrue(Integer.parseInt(professions.getText()) >= 2);

        WebElement courses = driver.findElement(By
                .cssSelector("ul.search-page-tabs a[data-tab='courses'] > span"));
        Assertions.assertTrue(Integer.parseInt(courses.getText()) > 15);

        WebElement webinars = driver.findElement(By
                .cssSelector("ul.search-page-tabs a[data-tab='webinars'] > span"));
        Assertions.assertTrue(Integer.parseInt(webinars.getText()) > 180
                && Integer.parseInt(webinars.getText()) < 300);

        WebElement blogs = driver.findElement(By
                .cssSelector("ul.search-page-tabs a[data-tab='blogs'] > span"));
        Assertions.assertTrue(Integer.parseInt(blogs.getText()) > 300);

        WebElement forums = driver.findElement(By
                .cssSelector("ul.search-page-tabs a[data-tab='forums'] > span"));
        Assertions.assertTrue(Integer.parseInt(forums.getText()) != 350);

        WebElement tests = driver.findElement(By
                .cssSelector("ul.search-page-tabs a[data-tab='tests'] > span"));
        Assertions.assertTrue(Integer.parseInt(tests.getText()) != 0);
    }

}
