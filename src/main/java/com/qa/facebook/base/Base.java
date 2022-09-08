package com.qa.facebook.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {
    public WebDriver driver;
    public Properties prop;

    public WebDriver init_driver(String browserName) {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Downloads\\chromedriver.exe");

            ChromeOptions option = new ChromeOptions();
            option.addArguments("--disable-notifications");
            driver = new ChromeDriver(option);

            if(prop.getProperty("headless").equals("yes")){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            }else{
                driver = new ChromeDriver();
            }
        }
//        else if{
//            System.setProperty("webdriver.gecko.driver","");
//            driver = new FirefoxDriver();
//        }
        return driver;
    }

    public Properties init_properties(){
        prop = new Properties();
        FileInputStream ip = null;
        try {
            ip = new FileInputStream("C:\\Users\\HP\\IdeaProjects\\KeyWordDrivenFB\\src\\main\\java\\" +
                    "com\\qa\\facebook\\config\\config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
