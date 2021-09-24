package com.lolaflora.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import static com.lolaflora.automation.Constant.Driver.driver;
import static com.lolaflora.automation.ElementUtils.*;

public class LinksControl {


    @Test
    public void brokenLinkTestCase() throws InterruptedException {


        String homePage = "https://www.lolaflora.com";
        String url = "";
        Integer validLink = 0;
        Integer invalidLink = 0;
        Integer externalLink = 0;
        Integer nullEmptyLink = 0;
        HttpURLConnection huc = null;
        Integer respCode = 200;
        goToUrl("https://www.lolaflora.com/login");

        //links isimli list içerisine sayfa içerisinde bulunan bütün linkler alınır
        List<WebElement> links = driver.findElements(By.tagName("a"));

        Iterator<WebElement> it = links.iterator();
        //List içerisinde bulunan linkler kontrol edilir.
        while(it.hasNext()){

            url = it.next().getAttribute("href");

            System.out.println(url);

            if(url == null || url.isEmpty()){
                System.out.println("URL null değere sahip");
                nullEmptyLink++;
                continue;
            }

            if(!url.startsWith(homePage)){
                System.out.println("URL external bir domaine ait");
                externalLink++;
                continue;
            }

            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());

                huc.setRequestMethod("HEAD");

                huc.connect();

                respCode = huc.getResponseCode();

                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                    invalidLink++;
                }
                else{
                    System.out.println(url+" is a valid link");
                    validLink++;
                }

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println(validLink +"valid link vardır");
        System.out.println(invalidLink+"invalid link vardır");
        System.out.println(externalLink +"external link vardır");
        System.out.println(nullEmptyLink+"null ya da Empty link vardır");



    }

}

