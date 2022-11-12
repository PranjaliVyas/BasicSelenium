import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchToAlertExample {

  static  WebDriver driver;


@Test
public void Switch() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
   String baseURL = "https://courses.letskodeit.com/practice";
    driver.get(baseURL);
    driver.findElement(By.className("inputs")).sendKeys("Pranjali");
   Thread.sleep(2000);
    System.out.println("input the name by classname elements");
driver.findElement(By.cssSelector("a.dynamic-link ")).click();
Thread.sleep(4000);
    System.out.println("found home tag and open ");

}
@After
    public void exit(){
    driver.quit();
}
}
