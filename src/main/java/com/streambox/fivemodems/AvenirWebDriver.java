package com.streambox.fivemodems;

/**
 * Created by vlad on 3/25/15.
 */

import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class AvenirWebDriver {

    public static WebDriver driver;
    private static String baseUrl;
    public static String ip;

    private static LogModemsWrite logger = new LogModemsWrite();
    private static ModemLogHomeDirectory modemsLogsHomeDirectory = new ModemLogHomeDirectory();
    private static String pathToModemLogFile;

    private static Date date = new Date();

    private static String actualTitle;
    private static String expectedTitle;

    private static String pathToNoModemsDetected = ".//*[@id='mlarea']/span";

    private static String checkIfModemsDetected;

    private static String sn;

    private static String logLine = "\r\n********************************************************************************\r\n";

    public void setIPforAvenir() {

        try {
            Process p = Runtime.getRuntime().exec("python /var/www/html/five_modems/apn_and_phone/ssh.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            sn = (in.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        driver = new FirefoxDriver();
        pathToModemLogFile = modemsLogsHomeDirectory.create_home_directory();

        InputStream input = null;
        try {
            input = new URL("http://10.0.3.93/five_modems/apn_and_phone/ip.txt").openStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            try {
                ip = (IOUtils.toString(input).trim());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } finally {
            IOUtils.closeQuietly(input);
        }

        try {

            baseUrl = "http://" + ip;
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().setSize(new Dimension(800, 600));
            //driver.manage().window().maximize();
            driver.get(baseUrl + "/");
            driver.get(baseUrl + "/avenir/index.php");

            pathToModemLogFile = modemsLogsHomeDirectory.create_home_directory();
            logger.modemsLogs("\r\n\t\t\tDate: " + date + "\r\n\r\n\t\tAvenir IP: " + ip + " - Avenir S/N: " + sn, pathToModemLogFile);
            logger.modemsLogs("\r\n********************************************************************************", pathToModemLogFile);
            logger.modemsLogs("********************************************************************************\r\n", pathToModemLogFile);

            actualTitle = driver.getTitle();
            //System.out.println(actualTitle);
            expectedTitle = "404 Not Found";

            if (actualTitle.equals(expectedTitle) || actualTitle.equals("Problem loading page")) {

                logger.modemsLogs("\t" + "Can't find path to Avenir, check your IP address - " + "Test failed\r\n", pathToModemLogFile);
                logger.modemsLogs(logLine, pathToModemLogFile);
                LogFileForOS openLogFile = new LogFileForOS();
                openLogFile.showLogFile();
                driver.close();

            } else {

                driver.findElement(By.linkText("Settings")).click();
                driver.findElement(By.linkText("Network")).click();
                //driver.findElement(By.xpath("//a[contains(text(),'WWAN')]")).click();
                driver.findElement(By.xpath("html/body/div[4]/table/tbody/tr[1]/td[3]/a[2]")).click();
                //driver.findElement(By.xpath("(//a[contains(text(),'WWAN')])[2]")).click();
                driver.findElement(By.xpath("html/body/div[4]/table/tbody/tr[5]/td[3]/span/a")).click();

                    checkIfModemsDetected = driver.findElement(By.xpath(pathToNoModemsDetected)).getText();

                    if (checkIfModemsDetected.equals("- No Modems Detected -")) {
                        try {
                        logger.modemsLogs("\t" + "No Modems Detected                                            " + "Test failed\r\n", pathToModemLogFile);
                        //logger.modemsLogs(logLine, pathToModemLogFile);
                        LogFileForOS openLogFile = new LogFileForOS();
                        openLogFile.showLogFile();
                        driver.close();
                        }catch (Exception e) {
                            System.out.println("No modems detected Exception");
                        }

                    } else {
                    }


            }
        } catch (Exception e) {

            // pathToModemLogFile = modemsLogsHomeDirectory.create_home_directory();
            //logger.modemsLogs('\t' + "Can't find path to Avenir, please check your IP address - " + "Test failed\r\n", pathToModemLogFile);
            //logger.modemsLogs(logLine, pathToModemLogFile);

        }

    }
}
