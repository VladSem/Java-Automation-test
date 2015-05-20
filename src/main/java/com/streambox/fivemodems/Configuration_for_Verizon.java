package com.streambox.fivemodems;

/**
 * Created by vlad on 3/25/15.
 */

import org.openqa.selenium.By;

public class Configuration_for_Verizon extends AvenirWebDriver {

    private OSValidator osValidator = new OSValidator();
    private boolean linux;
    private boolean mac;
    private boolean windows;

    private LogModemsWrite logger = new LogModemsWrite();
    private String pathToModemLogFile;
    private ModemLogHomeDirectory modemsLogsHomeDirectory = new ModemLogHomeDirectory();
    public String getAPN;
    public String getPhoneNo;

    public void set_modem_settings_for_verizon(String buttonReconnect) {

        pathToModemLogFile = modemsLogsHomeDirectory.create_home_directory();

        linux = osValidator.isUnix();
        mac = osValidator.isMac();
        windows = osValidator.isWindows();

        if (linux) {

            driver.findElement(By.xpath(".//*[@id='apn']")).clear();
            getAPN = driver.findElement(By.id("apn")).getAttribute("value");
            driver.findElement(By.id("tel")).click();
            driver.findElement(By.id("box")).clear();
            driver.findElement(By.id("box")).sendKeys("*99***3#");
            driver.findElement(By.xpath("//input[@value='Done']")).click();
            getPhoneNo = driver.findElement(By.id("tel")).getAttribute("value");
            driver.findElement(By.linkText("Save")).click();
            driver.findElement(By.xpath(buttonReconnect)).click();

        } else if (mac) {

            driver.findElement(By.id("apn")).clear();
            driver.findElement(By.id("apn")).sendKeys("");
            getAPN = driver.findElement(By.id("apn")).getAttribute("value");
            driver.findElement(By.id("tel")).clear();
            driver.findElement(By.id("tel")).sendKeys("*99***3#");
            getPhoneNo = driver.findElement(By.id("tel")).getAttribute("value");
            driver.findElement(By.linkText("Save")).click();
            driver.findElement(By.xpath(buttonReconnect)).click();

        } else if (windows) {

            driver.findElement(By.id("apn")).clear();
            driver.findElement(By.id("apn")).sendKeys("");
            getAPN = driver.findElement(By.id("apn")).getAttribute("value");
            driver.findElement(By.id("tel")).clear();
            driver.findElement(By.id("tel")).sendKeys("*99***3#");
            getPhoneNo = driver.findElement(By.id("tel")).getAttribute("value");
            driver.findElement(By.linkText("Save")).click();
            driver.findElement(By.xpath(buttonReconnect)).click();

        } else {
            System.out.println("Please, use Windows, Linux or Mac");
        }
    }

}
