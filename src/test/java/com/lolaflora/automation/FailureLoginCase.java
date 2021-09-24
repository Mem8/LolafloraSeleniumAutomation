package com.lolaflora.automation;

//import org.junit.Test;
import org.testng.annotations.Test;
import org.testng.Assert;

import static com.lolaflora.automation.ElementUtils.*;
import static com.lolaflora.automation.Constant.Driver.*;

public class FailureLoginCase {

    @Test
    public void failureTestCase() throws InterruptedException {
        //Go to url
        goToUrl("https://www.lolaflora.com/login");
        //Confirmation about right site
        String confirmation = driver.getTitle();
        Assert.assertEquals(confirmation,"Lolaflora.com");
        //Entering login credential
        sendKeysById("EmailLogin", "fedad24609@gizmona.com");
        sendKeysById("Password", "12341234321");
        //pressing login button
        clickElementByXpath("//*[@id=\"userLogin\"]/div[6]/button");
        //driver.findElement().click();
        Thread.sleep(3000);
        //confirmation about incorrect login
        String loginConfirmation = getTextWithXpath("//*[@id=\"modalBox\"]/div/div/div[2]");
        Assert.assertTrue(loginConfirmation.contains("incorrect"));


        //E-mail address or password is incorrect. Please check your information and try again.

    }
}
