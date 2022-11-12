import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownBox {
    WebDriver driver;
    String baseURL;
@Test
    public void dropDown() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        baseURL = "https://courses.letskodeit.com/practice";
        driver.manage().window().maximize();
        driver.get(baseURL);
        WebElement element = driver.findElement(By.id("carselect"));
        Select select= new Select(element);
        select.selectByIndex(2);
        Thread.sleep(3000);
    System.out.println("HONDA selected in dropdown box  ");
        select.selectByValue("bmw");
       Thread.sleep(2000);
    System.out.println("BMW selected in dropdown box  ");
select.selectByVisibleText("Benz");
Thread.sleep(2000);
    System.out.println("BENZ selected in dropdown box " );

    }



@After
    public  void exit(){
    driver.quit();
}




}
