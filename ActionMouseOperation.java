import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionMouseOperation {

    WebDriver driver;

    @BeforeMethod
    public void MouseOperationTestsBrowserOpen(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().window().maximize();
    }

    @Test
    public void MouseOperationTests1() throws InterruptedException {

        driver.get("https://www.leafground.com/drag.xhtml");                           //Actions >> Class,used to perform mouse actions
                                                                                       //Action  >> interface,used to perform actions class having actions
        System.out.println("1) <<<<<<<<<<<<<<<<Move to an element operation");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt37"))).perform();         //build().perform() = .perform()
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt38"))).perform();         //build().perform() = .perform()
        Thread.sleep(3000);
        actions.moveToElement(driver.findElement(By.id("menuform:j_idt39"))).perform();         //build().perform() = .perform()






        System.out.println("1) <<<<<<<<<<<<<<<<Drag and Drop operation");
        WebElement from =driver.findElement(By.id("form:drag_content"));
        WebElement to = driver.findElement(By.id("form:drop"));

        //actions.clickAndHold(from).moveToElement(to).release(to).perform();        // first method
        actions.dragAndDrop(from, to).perform();                                    // second method




        System.out.println("1) <<<<<<<<<<<<<<<<slider Operation");
        WebElement sliderpoint1 =driver.findElement(By.xpath("//*[@id='form:j_idt125']/span[1]"));
        System.out.println("Slider point 1 Location before moving" + sliderpoint1.getLocation());
        actions.dragAndDropBy(sliderpoint1,50,0).perform();
        System.out.println("Slider point 1 Location after moving" + sliderpoint1.getLocation());


    }

    @Test
    public void MouseOperationTests2() throws InterruptedException {
    driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<Right click>>>>>>>>>>>>>>>>>>");
    WebElement rightclickbutton =driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));

    Actions actions1=new Actions(driver);
    actions1.contextClick(rightclickbutton).perform();                                     // double click =  actions1.doubleclick
    driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
    Alert alertpop =driver.switchTo().alert();
    Thread.sleep(3000);
    System.out.println("Alert shows the text as : " + alertpop.getText());
    alertpop.accept();







    }

}
