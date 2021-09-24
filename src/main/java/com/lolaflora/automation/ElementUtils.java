package com.lolaflora.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static com.lolaflora.automation.Constant.Driver.*;
public class ElementUtils {


    public static void clickElementById(String id){
        driver.findElement(By.id(id)).click();
    }

    public static void clickElementByXpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void sendKeysById(String id,String keys){
        driver.findElement(By.id(id)).sendKeys(keys);
    }

    public static void sendKeysByXpath(String xpath,String keys){
        driver.findElement(By.xpath(xpath)).sendKeys(keys);
    }

    public static void findElementByXpath(String xpath){
        driver.findElement(By.xpath(xpath));
    }

    public static void goToUrl(String url) { driver.get(url);}

    public static String getTextWithTag(String tag) {String tagText =By.tagName(tag).findElement(driver).getText();
        return tagText;
    }

    public static String getTextWithXpath(String xpath) {String xpathText =By.xpath(xpath).findElement(driver).getText();
        return xpathText;
    }

    public static String getTextWithId(String id) {String idText =By.id(id).findElement(driver).getText();
        return idText;
    }

    public static String getValueWithXpath(String xpath) {String xpathValue = By.xpath(xpath).findElement(driver).getAttribute("value");
        return xpathValue;
    }

    public static void scrollAndClickByXpath(String xpath){
        WebElement scrollClick = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",scrollClick);
        scrollClick.click();
    }

}
