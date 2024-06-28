import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class DropDownExample {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
         driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void leafGroundPageDropDownTest() throws InterruptedException {
        // 1.1 ways of select values in basic dropdown
        driver.get("https://www.leafground.com/select.xhtml;jsessionid=node01l454cr2rt1x5e91ck59ul0ab4326125.node0");
        WebElement dropDown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);      //dropdown eke palaweni eka
        Thread.sleep(1000);
        select.selectByVisibleText("Playwright");       //pena namin call karanawa
        Thread.sleep(1000);
        select.selectByVisibleText("Cypress");       //pena namin call karanawa
        Thread.sleep(1000);


        // 1.2 Get the number of dropdown options
        // Generics - we can store only webelement
        List<WebElement> ListofOptions = select.getOptions();
        int size = ListofOptions.size();
        System.out.println("Number of elements in dropdown: " + size);

        for (WebElement element : ListofOptions) {
            System.out.println(element.getText());
        }


        // 1.3 Using sendkeys select dropdown value     //dropdown ekaka mula akura gahuwama vachane enawa
        dropDown.sendKeys("Puppeter");
        Thread.sleep(3000);


        // 1.4 Selecting value in a Bootstrap dropdown  start with <div

        WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropDown2.click();
        List<WebElement> listofdropdownvalues = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));  //list of web elements
        for (WebElement element : listofdropdownvalues) {
            Thread.sleep(300);
            String dropdownvalue = element.getText();   //element eke text eks eliyata gnnwa after store in string variable

            if (dropdownvalue.equals("USA")) {
                element.click();
                break;
            }

        }
    }

    // 2 Google search - pick a value from suggestions
    @Test
    public void Googlesearch() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(2000);
        List<WebElement> googlesearchlist = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
        System.out.println(googlesearchlist.size());
        for (WebElement element : googlesearchlist) {
            System.out.println(element.getText());



        }


    }


    // 3 Handle hidden auto suggestions drop down and search using DOM debugger trick
    }

