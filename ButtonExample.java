import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class ButtonExample{

    WebDriver driver;                                                          //initialize the driver

    @BeforeMethod                                                           //precondition
    public void OpenLinkTestPage(){
        driver = new ChromeDriver();                // Create the WebDriver instance           //open chrome browser
        driver.manage().window().maximize();


        //Dimension newsize = new Dimension(800, 600);
        //driver.manage().window().setSize(newsize);

        driver.get("https://www.leafground.com/button.xhtml;jsessionid=node0av0uvk4i613prw8j0n9rs4uz3883002.node0");

    }
    @Test
    public void buttonTests(){              //    1 click and confirm title
    driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
    String ExpectedTitle = "Dashboard";
    String ActualTitle = driver.getTitle();

    if(ExpectedTitle.equals(ActualTitle)){
        System.out.println("Actual Title same as expected");
    }else {
         System.out.println("Actual Title not same as expected");
        }
    //Assert.assertEquals(ActualTitle,ExpectedTitle,"Title miss matched");
//    driver.findElement(By )


//    2 find the position of the submit button
        driver.navigate().back();
    WebElement getposition  = driver.findElement(By.id("j_idt88:j_idt94"));
    Point xypoint = getposition.getLocation();
    int x = xypoint.getX();
    int Y = xypoint.getY();
    System.out.println("X position is : "+ x + " Y Position is : " + Y );


//    3 find the save button color

        WebElement buttoncolour = driver.findElement(By.id("j_idt88:j_idt96"));
        String Colour =  buttoncolour.getCssValue("background-color");
        System.out.println("Button Colour is : "+ Colour);

//    4 Find the Height and width of the button
    driver.findElement(By.id("j_idt88:j_idt98"));
    WebElement size = driver.findElement(By.id("j_idt88:j_idt99"));
    int Height = size.getSize().getHeight();
    int Width = size.getSize().getWidth();
    System.out.println("Height is : "+ Height + " Width is : "+ Width);





    }


}
