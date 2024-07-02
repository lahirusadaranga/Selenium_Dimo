import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandling {
    WebDriver driver;

    @BeforeMethod
    public void windowTestPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml;jsessionid=node0gheq5w6k6fh2r56qst5o7gs24691527.node0");
        Thread.sleep(3000);
    }

    @Test
    public void windowTests() throws InterruptedException {

//        1. click and confirm new window opens
        String olddwindow =driver.getWindowHandle();    // code for remember this is the parent windodw by selenium
        System.out.println("parent window :" + olddwindow);     //

        WebElement openbutton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));


        openbutton.click();
        Thread.sleep(5000);

        Set<String> handles =driver.getWindowHandles();
        System.out.println("handles size :" + handles.size());


//            first method - using for each loop

//        for(String newwindow:handles){
//            System.out.println(newwindow);
//            driver.switchTo().window(newwindow);            //swith to new window

        //  if(driver.gettitle().equals("xyz"){                 // title eka xyz unama stop execution
        //      break;
        //  }


//            System.out.println("page title is : " + driver.getTitle());
//
//        }
//        driver.close();
//                                                    //close=close the focused tab
////                                                 //quit=close all tabs
//
//        driver.switchTo().window(olddwindow);
//



//              second method - using list



        List<String> list = new ArrayList<String>();        //converting set to the list

        if (list.size()> 1){
            driver.switchTo().window(list.get(1));
            System.out.println("child tab title is : " + driver.getTitle());
            driver.close();
            driver.switchTo().window(olddwindow);

        }

        WebElement openbutton1 =driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openbuttonvisibility=openbutton1.isDisplayed();                                                  // element eka web page(dom eke) eke tynvda balanwa
        System.out.println("öpen button visibility" + openbuttonvisibility);

//        2. fin the number of opened tabs
    WebElement multiwinoowbutton =driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']/span"));
    multiwinoowbutton.click();
    Thread.sleep(3000);

    Set<String> multiwindows =driver.getWindowHandles();
    int howmanywindows = multiwindows.size();
        System.out.println("number of windows open :" + howmanywindows);



//        3. close all windows except primary
    WebElement dontcloseme =driver.findElement(By.xpath("//*[@id='j_idt88:j_idt93']/span[2]"));
    dontcloseme.click();
    Thread.sleep(3000);

    Set<String> newwindowhandles =driver.getWindowHandles();
    for(String allwindows:newwindowhandles){
        if (!allwindows.equals(olddwindow)){
            driver.switchTo().window(allwindows);
            driver.close();

        }
        }
//    driver.switchTo().window(olddwindow);
//    driver.close();

        driver.quit();

//    driver.close(); = close single browser window driver which on focus
//    driver.quit     = close all browser windodws


    }

    }

