import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class XpathPractice {
    WebDriver driver;
    String alert;

    @Before
    public void findXpath() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String baseURL = "https://courses.letskodeit.com/practice";
        driver.get(baseURL);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void xpath() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='bmwradio']")).click();
        driver.findElement(By.xpath("//input[@value='benz']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='honda']")).click();

    }

    @Test
    public void cssSelacter() {
        driver.findElement(By.cssSelector("option[value='apple']")).click();
        driver.findElement(By.cssSelector("option[value='peach']")).click();
        driver.findElement(By.cssSelector("option[value='orange']")).click();
    }

    @Test
    public void selectClass() throws InterruptedException {
        driver.findElement(By.xpath("//option[@value='bmw']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//option[@value='honda']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("option[value='benz']")).click();
        Thread.sleep(2000);
    }

    @Test
    public void checkBox() throws InterruptedException {
        driver.findElement(By.cssSelector("input#bmwcheck")).click();
        driver.findElement(By.xpath("//input[@id='benzcheck']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input#hondacheck")).click();
        Thread.sleep(2000);

    }

    @Test
    public void switchWindow() {
        driver.findElement(By.xpath("//button[@id='openwindow']")).click();
    }

    @Test
    public void switchTab() {
        driver.findElement(By.cssSelector("a#opentab")).click();


    }

    @Test
    public void switchToAlert() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("prv");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@class='btn-style']")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }

    @Test
    public void iframeswitch() {
        driver.switchTo().frame(0);//switch to frame by index
        //driver.switchTo().frame("courses-iframe");// switch to frame by id
        //driver.switchTo().frame("iframe-name");//switch to frame by name
        WebElement search = driver.findElement(By.xpath("//input[@id='search']"));
        search.sendKeys("java");
        search.sendKeys(Keys.ENTER);
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//iframe[@id='courses-iframe']")).click();


    }

    @Test
    public void disabldButton() {
        driver.findElement(By.id("disabled-button")).click();
        driver.findElement(By.cssSelector("input[class='inputs']"));
        System.out.println("field can't use");
        driver.findElement(By.id("enabled-button")).click();
        driver.findElement(By.cssSelector("#enabled-example-input")).sendKeys("field is enabled");

    }

    @Test
    public void elementDisplayed() throws InterruptedException {
        driver.findElement(By.id("hide-textbox")).click();
        System.out.println("DISPLAY hide");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='show-textbox']")).click();
        driver.findElement(By.id("displayed-text")).sendKeys("PRV");
    }

    @Test
    public void mouseHover() throws InterruptedException {
        WebElement element1 = driver.findElement(By.id("mousehover"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element1).perform();
        WebElement top = driver.findElement(By.xpath("//a[@href='#top']"));
        Thread.sleep(2000);
        actions.moveToElement(top).click().perform();
        Thread.sleep(2000);
        WebElement element2 = driver.findElement(By.id("mousehover"));
        actions.moveToElement(element2).perform();
   WebElement reloadPage=driver.findElement(By.xpath("//*[@id='mouse-hover-example-div']/div/fieldset/div/div/a[2]"));
   Thread.sleep(2000);
        actions.moveToElement(reloadPage).click().perform();
        Thread.sleep(2000);
    }
@After
    public void exit(){
        driver.quit();
}
}


