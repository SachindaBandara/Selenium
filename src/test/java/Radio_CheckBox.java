import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Radio_CheckBox {
    WebDriver driver;

    @BeforeMethod
    public void Radio_CheckBox_TestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Open Browser

    }

    @Test

    public void radioTests(){
        // Find the default select radio button

        driver.get("https://www.leafground.com/radio.xhtml");

        boolean chromeradioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean fireFoxradioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariradioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeradioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeradioOption){
            String chromeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:0']")).getText();
            System.out.println("Default select radio button is : " + chromeText );
        } else if (fireFoxradioOption) {
            String fireFoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1']")).getText();
            System.out.println("Default select radio button is : " + fireFoxText );
        }else if (safariradioOption) {
            String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2']")).getText();
            System.out.println("Default select radio button is : " + safariradioOption );
        }else if (edgeradioOption) {
            String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3']")).getText();
            System.out.println("Default select radio button is : " + edgeText );
        }


        // Select the age group( only if not selected )

//        WebElement myAgeGroup = driver.findElement(By.id("j_idt87:age:0"));
//        boolean isChecked = myAgeGroup.isSelected();
//
//        if(!isChecked){
//            driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
//        }

        String myAge = "21-40 Years";

        List<WebElement> ageGroup = driver.findElements(By.xpath("//div[@id = 'j_idt87:age']//label"));

        for (WebElement element : ageGroup){
            String ageGroupText = element.getText();

            if (ageGroupText.equals(myAge)){
                WebElement myAgeRadioOption = driver.findElement(By.xpath("//label[text()='" + ageGroupText + "']/parent::div//input"));

                if (!myAgeRadioOption.isSelected()){
                    element.click();
                }
            }
        }
    }

    @Test

    public void CheckBoxTests(){

        // Select wanted checkboxes and verifying those checkboxes selected status

        driver.get("https://www.leafground.com/checkbox.xhtml");

        List<WebElement> checkboxList = driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
        for (WebElement element : checkboxList){

            if (!(element.getText().equals("Others"))){
                element.click();
            }
        }

        for (int i=1; i<=checkboxList.size(); i++){
            boolean checkboxStatus = driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)[" + i+"]")).isSelected();
            System.out.println("Checkbox "+ i + "selected status is " + checkboxStatus);
        }

    }

}
