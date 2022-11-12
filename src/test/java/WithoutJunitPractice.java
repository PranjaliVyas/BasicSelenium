import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WithoutJunitPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver;
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.next.co.uk");
        driver.quit();
        Thread.sleep(3000);
        System.out.println("Open next successfully");

    }
}