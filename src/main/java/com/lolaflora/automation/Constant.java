package com.lolaflora.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class Constant {

    public static class Driver{
        public static WebDriver driver;

        static {
            //chromedriver location
            System.setProperty("webdriver.chrome.driver","C:\\devtools\\driver\\chromedriver93.exe");
            //Create a map to store preferences
            Map<String, Object> prefs = new HashMap<String, Object>();
            //2 value for block notification
            prefs.put("profile.default_content_setting_values.notifications", 2);
            //Create an instance of ChromeOptions
            ChromeOptions options = new ChromeOptions();
            // set ExperimentalOption - prefs
            options.setExperimentalOption("prefs", prefs);
            //initialize chrome driver with prefs
            driver = new ChromeDriver(options);
            //maximize window
            driver.manage().window().maximize();
        }




        /*
       If you don't necessarily need to "Allow", but just want to get rid of the dialog,
       you can also just simulate the escape key, which will dismiss the dialog.
       new Actions().sendKeys(Keys.ESCAPE).build().perform(); – Matthijs Wessels Sep 4 '17 at 13:45
        browser.keys("Escape"); // Dismiss "notifications" dialog box.
         */



    }

}
