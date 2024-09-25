import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class OpenGoogle {

    @Test
    public void  googleTest(){

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("122"); // change the chrome browser version
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver(chromeOptions);
        // Open Browser
        driver.get("https://www.google.com");
        // Search Bar
        driver.findElement(By.name("q")).sendKeys("Colombo" + Keys.ENTER);


        //driver.quit();
    }


}
