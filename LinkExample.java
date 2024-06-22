import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;


public class LinkExample {

    WebDriver driver;

    
    @BeforeMethod
    public void OpenLinkTestPage(){
        driver = new ChromeDriver();  // Create the WebDriver instance
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }


//    1 Take me to dashboard
    @Test
    public void linktest(){
        WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink.click();
        driver.navigate().back();  // back to page



//    2 Find my destination
        WebElement WheretoGo = driver.findElement(By.partialLinkText("Find the URL without clicking me."));
        String path = WheretoGo.getAttribute("href");
        System.out.println("This link is going to : " + path);

////    3 Am i broken link
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();
        String title = driver.getTitle();   //title eka aran string ekaka save karanwa
        if(title.contains("404")){
            System.out.println("The link is broken");
        } else{
            System.out.println("Not broken");
        }
        driver.navigate().back();  // back to page
//
////    4 Duplicate link
        WebElement homeLink2 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink2.click();
        driver.navigate().back();
//
////    5 Count page links
//
        List<WebElement> countfullpagelink =  driver.findElements(By.tagName("a"));        //use findElements  a eka h ref wala thiyena eka
        int pagelinkcount = countfullpagelink.size();
        System.out.println("count of full page link : " + pagelinkcount);
//
////    6 Count layout links
        WebElement layoutElement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countofLayoutLinks = layoutElement.findElements(By.tagName("a"));
        System.out.println("Count of layout Links : " + countofLayoutLinks.size() );
    }

}
