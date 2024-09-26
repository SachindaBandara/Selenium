import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        // Find the defult select radio button

        driver.get("https://www.leafground.com/radio.xhtml");

        boolean chromeradioOption = driver.findElement(By.id("j_idt87:console2:0")).isSelected();
        boolean fireFoxradioOption = driver.findElement(By.id("j_idt87:console2:1")).isSelected();
        boolean safariradioOption = driver.findElement(By.id("j_idt87:console2:2")).isSelected();
        boolean edgeradioOption = driver.findElement(By.id("j_idt87:console2:3")).isSelected();

        if (chromeradioOption){
            String chromeText = driver.findElement(By.xpath("//lable[@for='j_idt87:console2:0']")).getText();
            System.out.println("Defult select radio button is : " + chromeText );
        } else if (fireFoxradioOption) {
            String fireFoxText = driver.findElement(By.xpath("//lable[@for='j_idt87:console2:1']")).getText();
            System.out.println("Defult select radio button is : " + fireFoxText );
        }else if (safariradioOption) {
            String fsafariText = driver.findElement(By.xpath("//lable[@for='j_idt87:console2:2']")).getText();
            System.out.println("Defult select radio button is : " + fsafariText );
        }else if (edgeradioOption) {
            String edgeText = driver.findElement(By.xpath("//lable[@for='j_idt87:console2:3']")).getText();
            System.out.println("Defult select radio button is : " + edgeText );
        }


        // Select the age group( only if not selected )

    }

    @Test

    public void CheckBoxTests(){

    }

}
