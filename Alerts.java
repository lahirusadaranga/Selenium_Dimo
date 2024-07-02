import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alerts {

    WebDriver driver;
    @BeforeMethod
    public void alerttestpage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node0gheq5w6k6fh2r56qst5o7gs24691527.node0");

    }
    @Test
    public void alerttest() throws InterruptedException {

        //1))  Alert simple Dialog

        WebElement alertbox = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt91']"));
        alertbox.click();
        Thread.sleep(3000);
        Alert alert1 =driver.switchTo().alert();
        Thread.sleep(3000);
        alert1.accept();

        //2)) Alert confirm dialog

        WebElement confirmbox =driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93'] "));
        confirmbox.click();
        Thread.sleep(3000);
        Alert alert2 =driver.switchTo().alert();
        Thread.sleep(3000);
        alert2.dismiss();

//        // 3)) Alert Promt Dialog

        WebElement Promtbox =driver.findElement(By.id("j_idt88:j_idt104"));
        Promtbox.click();
        Alert alert3 =driver.switchTo().alert();
        Thread.sleep(3000);
        String alerttext =alert3.getText();
        System.out.println("Alert text is : "+alerttext);
        alert3.sendKeys("my name is lahiru");
        alert3.accept();




    }
}
