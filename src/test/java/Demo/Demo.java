package Demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo {

    public static WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void demo(){
        String url = "https://google.com";

        driver.get(url);
        Assert.assertEquals(driver.getTitle(),"Gooogle");

    }
}
