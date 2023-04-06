package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.TestUtils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class WebTest {
    public static WebDriver driver;
    public static Properties prop;

    public WebTest(){
        //try catch defines fie input
        try {  //) error fixed checked done
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"src/main/resources/properties/config.properties");//declaredpropertrtiesclass
            prop = new Properties(); //initializing properties class object
            prop.load(fileInputStream);//storing file- compile time exception expected*loading
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) { //why we used? maybe to handle exception????
            e.printStackTrace();

        }

        //how to initialize method to initialize driver so no need to repeat
        public static void initialization() {
            String browserName = prop.getProperty("browser"); //fetch ini property whr is thr browser and come frm????
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "src/main/resources/drivermanager/chromedriver.exe");
                driver = new ChromeDriver();

               // WebDriverManager.chromedriver().setup(); //try with this also
               // driver = new ChromeDriver();

            } else if (browserName.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "src/main/resources/drivermanager/chromedriver.exe");
                driver = new FirefoxDriver();

               // WebDriverManager.firefoxdriver().setup();
                //driver = new FirefoxDriver();

            } else if (browserName.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "src/main/resources/drivermanager/chromedriver.exe");
                driver = new EdgeDriver();

               // WebDriverManager.edgedriver().setup();
               // driver = new EdgeDriver();

            } else if (browserName.equalsIgnoreCase("safari")) {
                System.setProperty("webdriver.safari.driver", System.getProperty("user.dir") + "src/main/resources/drivermanager/chromedriver.exe");
                driver = new SafariDriver();

               // WebDriverManager.safaridriver().setup();
                //driver = new SafariDriver();

            } else {
                try { //throw for not valid browser use
                    throw new Exception("Enter valid browser name");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //driver.navigate().to("https://magento.softwaretestingboard.com/");
            driver.navigate().to(prop.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_WAIT));//goto TestUtils files
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
            driver.manage().deleteAllCookies();
        }
    }
}




