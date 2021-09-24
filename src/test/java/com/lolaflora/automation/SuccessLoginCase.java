package com.lolaflora.automation;

//import org.junit.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.lolaflora.automation.Constant.Driver.*;
import static com.lolaflora.automation.ElementUtils.*;


public class SuccessLoginCase {


    @Test
    public void successTestCase() throws InterruptedException {
        //Go to Url
        goToUrl("https://www.lolaflora.com/login");

        //Confirmation about right site
        String confirmation = driver.getTitle();
        Assert.assertEquals(confirmation,"Lolaflora.com");
        //Entering login credential
        sendKeysById("EmailLogin", "fedad24609@gizmona.com");
        sendKeysById("Password", "12341234");
        //pressing login button
        clickElementByXpath("//*[@id=\"userLogin\"]/div[6]/button");
        Thread.sleep(3000);
        //confirmation about incorrect login

        goToUrl("https://www.lolaflora.com/account/edit-information");
        String accountName = getValueWithXpath("//*[@id=\"Name\"]");
        Assert.assertEquals(accountName,"gizmona");

        //WebDriverWait wait = new WebDriverWait(driver, 10);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login"))).click();

        /*
        Login Info
        mail: fedad24609@gizmona.com
        pw: 12341234
         */


    }
}
