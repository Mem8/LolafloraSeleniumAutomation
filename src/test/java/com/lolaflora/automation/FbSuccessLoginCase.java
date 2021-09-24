package com.lolaflora.automation;

//import org.junit.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.lolaflora.automation.ElementUtils.*;
import static com.lolaflora.automation.ElementUtils.getTextWithXpath;
import static com.lolaflora.automation.Constant.Driver.*;

public class FbSuccessLoginCase {
    @Test
    public void fbSuccessTestCase() throws InterruptedException {
        //Go to url
        goToUrl("https://www.lolaflora.com/login");
        //Confirmation about right site
        String confirmation = driver.getTitle();
        Assert.assertEquals(confirmation,"Lolaflora.com");
        //Clicking Facebook login button
        clickElementByXpath("/html/body/main/div/div[2]/div/a[1]");
        Thread.sleep(3000);

        //Switching opened pop-up window
        for (String currentWindow: driver.getWindowHandles())
            driver.switchTo().window(currentWindow);
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        //Entering login credential
        sendKeysByXpath("//*[@id=\"email\"]", "fedad24609@gizmona.com");
        sendKeysByXpath("//*[@id=\"pass\"]", "gizmona24609");
        //pressing login button

        clickElementByXpath("//*[@id=\"loginbutton\"]");

        //Hesap birçok denemeden sonra bloke olduğu için aşağıda bulunan confirmation ve yönlendirme kısmı çalışmıyor
        //WebDriverWait wait1 = new WebDriverWait(driver,10);
        //wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[1]"))).click();
        //WebDriverWait wait2 = new WebDriverWait(driver,10);
        //wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div/div/form/div/div[1]/div[2]/div[1]/div[2]/div[1]/button"))).click();
        //clickElementByXpath("//*[@id=\"u_0_12_7E\"]/div[2]/div[1]/div[2]/div[1]/button");


        //pw:gizmona24609


    }

}
