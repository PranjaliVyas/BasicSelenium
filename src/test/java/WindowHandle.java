import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle {
    WebDriver driver;
    String baseURL = "https://courses.letskodeit.com/practice";

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Nirav has made an chnages.
    }

    @Test
    public void windowHandlePractice() throws InterruptedException {
        String parentWindowHandle = driver.getWindowHandle();
        System.out.println("This is Parent Window handle");
        System.out.println(parentWindowHandle);

        //New Window
        driver.findElement(By.id("openwindow")).click();
        Set<String> handles =  driver.getWindowHandles();
        System.out.println(handles);

        for (String handle: handles) {
            System.out.println(handle);
            if(!handle.equals(parentWindowHandle)){
                driver.switchTo().window(handle);
                Thread.sleep(2000);
                driver.findElement(By.xpath("//*[@id='navbar-inverse-collapse']/div/div/a")).click();
                Thread.sleep(4000);
                driver.close();
                break;
            }
        }
        Thread.sleep(2000);


        driver.switchTo().window(parentWindowHandle);
        driver.findElement(By.id("name")).sendKeys("prv");
        Thread.sleep(2000);

    }

    @After
    public void exit() {
        driver.quit();
    }
}
