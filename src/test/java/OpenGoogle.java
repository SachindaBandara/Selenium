import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class OpenGoogle {

    @Test
    public void  googleTest(){
        WebDriver driver = new ChromeDriver();
        // Open Browser
        driver.get("https://www.google.com");
        // Search Bar
        driver.findElement(By.name("q")).sendKeys("Colombo" + Keys.ENTER);


        //driver.quit();
    }


}
