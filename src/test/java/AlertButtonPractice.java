import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertButtonPractice {
    static WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
         String  baseURL = "https://courses.letskodeit.com/practice";
        driver.get(baseURL);
    }

    @Test
    public void byElements() throws InterruptedException {

        driver.findElement((By.id("hondaradio"))).click();
        Thread.sleep(2000);
        System.out.println("honda button selected by id");
        Thread.sleep(2000);
        driver.findElement(By.id("bmwradio")).click();


        Thread.sleep(2000);
        System.out.println("bmw button selected by name");
        driver.findElement(By.xpath("//*[@id=\"benzradio\"]")).click();
        Thread.sleep(2000);
        System.out.println("benz button selected by xpath");


    }

        @Test
                public void searchBox(){



        }




        @After
        public void exit() {
            driver.quit();
        }
    }