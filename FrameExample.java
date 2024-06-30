import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FrameExample {
    WebDriver driver;

//   ****8 frames = html page,inside main html page (need to switch one time)
//                html
//                    html



//  ******  nested frame = need to switch two times
//            html
//                html
//                    html


    @BeforeMethod
    public void frameTestpage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml;jsessionid=node01l4ss63hve7ju1oo8n9grsfq4v4704594.node0");

    }

    @Test
    public void frameTest(){

//    1   click me (inside frame)                                        // .frame using to when html page inside a another html page
      driver.switchTo().frame(0);                                //There are four types to go to frame      driver.switchTo().frame(index/name/id//Webelement)
      WebElement button1 =driver.findElement(By.xpath("//button[@id='Click']"));          // because use iframe   iframe= html page inside a another html page
      button1.click();
      String afterclickbuttontext =button1.getText();                                                                                  // we cant use gettext command because
      System.out.println("After click inside frame button text" + afterclickbuttontext);

//    2   click me (inside nested frame)
      driver.switchTo().defaultContent();              // go to mail html page/frame
      driver.switchTo().frame(2);                // go to third frame
      driver.switchTo().frame("frame2");      // inside into third frame > child frame

      WebElement button3 =driver.findElement(By.id("Click"));
      button3.click();

      String afterclickNESTEDbuttontext =button3.getText();
      System.out.println("After click inside NESTED frame button text" + afterclickNESTEDbuttontext);



//    3   how many frames in this page                 // count iframe Tags
      driver.switchTo().defaultContent();
      List<WebElement> getFrameTagcount =driver.findElements(By.tagName("iframe"));              // List<WebElement> speak as LIST OF WEBELEMENTS
      int size =getFrameTagcount.size();
      System.out.println("Total framecount is :" + size);

      for(WebElement iframeElement :getFrameTagcount){
         String framesrcattributevalue =iframeElement.getAttribute("src");
          System.out.println("frame src attribute value" + framesrcattributevalue);
      }
//

    }

}

//     Frame = driver.switchTo.frame();
//     Window = driver.switchTo.window();
//     Alert = driver.switchTo.alert();