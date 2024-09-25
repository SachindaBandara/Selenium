import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Textboxes {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Open Browser
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public  void textBoxTests(){
        // type your name
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("Sachinda");

        //Append country to this city
        WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
        appendText.sendKeys("India");

        //Verify if text box is disable
        boolean enabled = driver.findElement(By.name("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Textbox enabled" + enabled);

        // Clear the typed text
        WebElement clearText = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));
        clearText.clear();

        // Retrieve the typed text
        WebElement textElement = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = textElement.getAttribute("value");
        System.out.println(value);

        // Type email and tab. Confirm control moved to next element
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("udenimansjhd22@gmail.com" + Keys.TAB + "Confirm control moved to next element");

    }
}
