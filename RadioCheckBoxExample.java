import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RadioCheckBoxExample {
   WebDriver driver;

   @BeforeMethod
    public void radio_check_box_BeforeTest(){
       driver = new ChromeDriver();
       driver.manage().window().maximize();
   }

   @Test
    public void radioTest(){
//       <<<<<<<<<<<<<<<<Radio>>>>>>>>>>>>>>
//       1 find the default select radio Button
       driver.get("https://www.leafground.com/radio.xhtml;jsessionid=node01pxo78bilf77it3gbct77wsc74690173.node0");
       boolean chromeradiooption =driver.findElement(By.id("j_idt87:console2:0")).isSelected();
       boolean firefoxradiooption =driver.findElement(By.id("j_idt87:console2:1")).isSelected();
       boolean safariradiooption =driver.findElement(By.id("j_idt87:console2:2")).isSelected();
       boolean edgeradiooption =driver.findElement(By.id("j_idt87:console2:3")).isSelected();

       if (chromeradiooption){
           String ChromexText =driver.findElement(By.xpath("//label[@for='j_idt87:console2:0'] ")).getText();
           System.out.println("default select radio Button is" + ChromexText );
       } else if (firefoxradiooption) {
           String firefoxText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:1'] ")).getText();
           System.out.println("default select radio Button is" + firefoxText);
       } else if (safariradiooption) {
           String safariText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:2'] ")).getText();
           System.out.println("default select radio Button is" + safariText);
       } else if (edgeradiooption) {
           String edgeText = driver.findElement(By.xpath("//label[@for='j_idt87:console2:3'] ")).getText();
           System.out.println("default select radio Button is" + edgeText);


       }


//       2 select the age group(only in not selected)       is selected work only with input tag
       WebElement myagegroup =driver.findElement(By.id("j_idt87:age:0"));
       boolean ischecked =myagegroup.isSelected();
       if (!ischecked){                                   // ! means not equal
            //myagegroup.click90;
           driver.findElement(By.xpath("//label[@for='j_idt87:age:0']")).click();
       }

   }

   @Test
    public void checkboxTest(){
//       <<<<<<<<<<<<<<<<<<Checkbox>>>>>>>>>>>
//       1 select wanted checkboxes and verifying those checkboxes selected status
      driver.get("https://www.leafground.com/checkbox.xhtml;jsessionid=node01pxo78bilf77it3gbct77wsc74690173.node0");
       List<WebElement> checkboxlist =driver.findElements(By.xpath("//table[@id='j_idt87:basic']//label"));
       for (WebElement element:checkboxlist) {
           if (!(element.getText().equals("others"))){         // ! =not equals
               element.click();
           }
       }

       for (int i=1; i<=checkboxlist.size(); i++){
           boolean checkBoxStatus =driver.findElement(By.xpath("(//table[@id='j_idt87:basic']//input)["+ i+"]")).isSelected();
           System.out.println("Checkbox " + i + "Selected status is :" + checkBoxStatus);

       }



   }
}
