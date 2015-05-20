package com.streambox.fivemodems;

import org.openqa.selenium.By;

/**
 * Created by vlad on 3/25/15.
 */
public class FindTextOnWebPage extends AvenirWebDriver{

    public static boolean checkText(String text){
        return driver.getPageSource().contains(text);
    }

    public static String checkString(String path){
//        text = driver.findElement(By.xpath(text)).getText();
//        return text;
        return driver.findElement(By.xpath(path)).getText();
    }

}
