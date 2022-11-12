import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class AutomationPractice {
    static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void test1() throws InterruptedException {
        String baseURL = "http://www.argos.co.uk";
        driver.get(baseURL);
        Thread.sleep(3000);
    }
    @Test
    public void test2() throws InterruptedException {
        String baseURL = "https://www.next.co.uk/";
        driver.get(baseURL);
        Thread.sleep(3000);
    }
    @Test
    public void test3() throws InterruptedException {
        String baseURL = "https://www2.hm.com/en_gb/index.html";
        driver.get(baseURL);
        Thread.sleep(4000);
    }
    @Test
    public void test4() throws InterruptedException {
        String baseURL = "https://www.sainsburys.co.uk/";
        driver.get(baseURL);
        Thread.sleep(1000);
    }
@After
    public void exit(){
        driver.quit();

    }
}