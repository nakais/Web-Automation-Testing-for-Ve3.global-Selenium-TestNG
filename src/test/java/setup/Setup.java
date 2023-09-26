package setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeTest;


import java.time.Duration;

public class Setup {

    public WebDriver driver;
    public String baseUrl = "https://www.ve3.global/";

    @BeforeTest
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
}
