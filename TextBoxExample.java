import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxExample {

    WebDriver driver;                                                          //initialize the driver


    @BeforeMethod                                                           //precondition
    public void OpenLinkTestPage() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBrowserVersion("122");
        driver = new ChromeDriver(chromeOptions);                                        // Create the WebDriver instance           //open chrome browser
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml;jsessionid=node01jq2c3914gbap1lm7j4gbn4rty3797579.node0");

    }

    @Test
    public void textboxExample(){
//    1 type your name
    WebElement name = driver.findElement(By.id("j_idt88:name"));    //store web element
    name.sendKeys("Lahiru Sandaranga");


//    2 Append country to this city

       WebElement appendText = driver.findElement(By.id("j_idt88:j_idt91"));
       appendText.sendKeys("Sri Lanka");

//    3 verify if text box is disabled
        boolean enabled =driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is Text Box Enabled: "+enabled);

//    4 clear the type text
       WebElement clearText  = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt95']"));           //Xpath=//tagname[@attribute='Value']
        clearText.click();                                                                                        //two types of x paths    // Relative , Absolute


//    5 Retrieve the type text

        WebElement RetrieveText = driver.findElement(By.id("j_idt88:j_idt97"));
        String Value = RetrieveText.getAttribute("value");
        System.out.println(Value);

//    6 type email and tab.confirm control moved to next element
        driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("lahirusadaranga5911@gmail.com" + Keys.TAB);

    }


}
