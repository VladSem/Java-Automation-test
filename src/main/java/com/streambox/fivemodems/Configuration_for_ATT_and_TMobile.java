package com.streambox.fivemodems;

/**
 * Created by vlad on 3/25/15.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Configuration_for_ATT_and_TMobile extends AvenirWebDriver {

    private OSValidator osValidator = new OSValidator();
    private boolean linux;
    private boolean mac;
    private boolean windows;

    private LogModemsWrite logger = new LogModemsWrite();
    private String pathToModemLogFile;
    private ModemLogHomeDirectory modemsLogsHomeDirectory = new ModemLogHomeDirectory();
    public String getAPN;
    public String getPhoneNo;

    public void set_modem_settings_for_att_tmobile(String buttonReconnect) {

        pathToModemLogFile = modemsLogsHomeDirectory.create_home_directory();

        linux = osValidator.isUnix();
        mac = osValidator.isMac();
        windows = osValidator.isWindows();

        if (linux) {

            driver.findElement(By.xpath(".//*[@id='apn']")).clear();
            driver.findElement(By.xpath(".//*[@id='apn']")).sendKeys("broadband");
            driver.findElement(By.xpath("//input[@value='Done']")).click();
            getAPN = driver.findElement(By.id("apn")).getAttribute("value");
            driver.findElement(By.id("tel")).click();
            driver.findElement(By.id("box")).clear();
            driver.findElement(By.xpath("//input[@value='Done']")).click();
            getPhoneNo = driver.findElement(By.id("tel")).getAttribute("value");
            driver.findElement(By.linkText("Save")).click();
            driver.findElement(By.xpath(buttonReconnect)).click();

        } else if (mac) {

            driver.findElement(By.id("apn")).clear();
            driver.findElement(By.id("apn")).sendKeys("broadband");
            getAPN = driver.findElement(By.id("apn")).getAttribute("value");
            driver.findElement(By.id("tel")).clear();
            driver.findElement(By.id("tel")).sendKeys("");
            getPhoneNo = driver.findElement(By.id("tel")).getAttribute("value");
            driver.findElement(By.linkText("Save")).click();
            driver.findElement(By.xpath(buttonReconnect)).click();

        } else if (windows) {
            driver.findElement(By.id("apn")).clear();
            driver.findElement(By.id("apn")).sendKeys("broadband");
            getAPN = driver.findElement(By.id("apn")).getAttribute("value");
            driver.findElement(By.id("tel")).clear();
            driver.findElement(By.id("tel")).sendKeys("");
            getPhoneNo = driver.findElement(By.id("tel")).getAttribute("value");
            driver.findElement(By.linkText("Save")).click();
            driver.findElement(By.xpath(buttonReconnect)).click();

        } else {
            System.out.println("Please, use Windows, Linux or Mac");
        }
    }

}
