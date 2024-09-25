import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownMenu {
    WebDriver driver;

    @BeforeMethod
    public void dropDownTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Open Browser

    }

    @Test

    public void leafgroundpageDropDownTest() throws InterruptedException {

        // Ways of select values in basic dropdown
        driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        Thread.sleep(3000);

        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

        // Get the number of dropDown options
        List<WebElement> listofOptions = select.getOptions();
        int size = listofOptions.size();
        System.out.println("Number of elements in dropdown :" + size);

        for (WebElement element : listofOptions){
            System.out.println(element.getText());
        }

        // Using sendkeys select dropdown value
        dropDown.sendKeys("Puppeteer");
        Thread.sleep(3000);

        // Selecting value in a Boostrap Dropdown
        WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown2.click();

        List<WebElement> lisOfDropDown2Values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element : lisOfDropDown2Values) {
            String dropDownValue = element.getText();

            if(dropDownValue.equals("USA")){
                element.click();
                break;
            }
        }
    }

    // Google Search - pick a value from suggestions

    @Test
    public void googleSearchDropDown() throws InterruptedException {
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("palitha");

        Thread.sleep(2000);
        List<WebElement> listOfDropDown3 = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
        System.out.println(listOfDropDown3.size());
    }



}