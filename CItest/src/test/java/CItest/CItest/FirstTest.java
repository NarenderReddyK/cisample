package CItest.CItest;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Assert;
import java.util.concurrent.TimeUnit;
import java.net.URL;

import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;


public class FirstTest {

//	public AppiumDriver<WebElement> driver;
	private static EnhancedAndroidDriver<MobileElement> driver;
	@Rule
    public TestWatcher watcher = Factory.createWatcher();

    @Test
    public void firstTest() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Nexus_5_API_25");
            capabilities.setCapability("app", "C:\\Users\\venkateshl\\eclipse-workspace\\CItest\\app-debug.apk");
            capabilities.setCapability("automationName", "UiAutomator2");
            capabilities.setCapability("autoAcceptAlerts", true);
            capabilities.setCapability("locationServicesAuthorized", true);
//            capabilities.setCapability("fastReset", "true");
            
            
//           driver= new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);{}
            driver = Factory.createAndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
           
           driver.findElement(By.id("btn_submit")).click();
           String txt = driver.findElement(By.id("lbl_message")).getText();
           Assert.assertTrue(txt.equals("Hello World!"));
           driver.closeApp();
           
        }catch(Exception e){
            e.printStackTrace();
        } finally {
        }
    }

    @After
    public void TearDown(){
        driver.label("Stopping App");
        driver.quit();
    }
}