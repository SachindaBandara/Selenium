import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WorkingWithLinks {

    private static final Logger log = LoggerFactory.getLogger(WorkingWithLinks.class);

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Open Browser
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test
    public void linkTest() {
        // Take me to dashboard
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();

        // Find My destination
        WebElement whereToGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = whereToGo.getAttribute("href");
        System.out.println("This is the path of link :" + path);

        // Am I broken link?
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if (title.contains("404")) {
            System.out.println("This link is broken");
        } else {
            System.out.println("This link is not broken");
        }
        driver.navigate().back();

        // Duplicate Link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();

        // Count page links
        List<WebElement> countFullPageLinks = driver.findElements(By.tagName("a"));
        int pageLinksCounts = countFullPageLinks.size();
        System.out.println("Count of the full page links : " + pageLinksCounts);

        // Count layout links
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countOfLayoutElement = layoutElement.findElements(By.tagName("a"));
        System.out.println("Count of the full page links : " + countOfLayoutElement.size());

    }
}