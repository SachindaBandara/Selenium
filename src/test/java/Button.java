import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Button {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage(){
        driver = new ChromeDriver();
        Dimension newSize = new Dimension(800, 600);
        driver.manage().window().setSize(newSize);
        //driver.manage().window().maximize();
             // Open Browser
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test

            public void buttonTest(){

        // Click and Confirm title
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Actual Title same as expected");
        } else {
            System.out.println("Actual Title not same as expected");
        }

        // Find the position of the submit button
        driver.navigate().back();

        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xypoints = getPosition.getLocation();
        int x = xypoints.getX();
        int y = xypoints.getY();
        System.out.println("X position is : " + x + " Y position is : " + y );

        // Find the save button color
        WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt96"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println("button Color is : " + color);

        // Find the height and width of this button
        WebElement size = driver.findElement(By.id("j_idt88:j_idt98"));
        int height = size.getSize().getHeight();
        int width = size.getSize().getWidth();
        System.out.println("Height : " + height + " Width : " + width);


    }
}
