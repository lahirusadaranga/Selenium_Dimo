import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Opengoogletest{
    @Test
    public void googletest(){
        //ChromeOptions Co = ChromeOptions.addArguments("--headless");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.id("APjFqb")).sendKeys("wallet" + Keys.ENTER );
//        driver.findElement(By.id("APjFqb")).sendKeys("colombo");

        //driver.quit();
    }
}
