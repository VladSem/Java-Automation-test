package com.streambox.fivemodems;

import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by vlad on 4/3/15.
 */
public class Modem_Reconnect extends AvenirWebDriver {

    private LogModemsWrite logger = new LogModemsWrite();

    private static String checkReconnectButtonValue;

    private long tStart;
    private long tEnd;
    private long tDelta;
    private static double elapsedSeconds;

    public void clickReconnectMissingModems(String pathToReconnectButton, String modem, String pathToModemLogFile) {

        try {
            checkReconnectButtonValue = driver.findElement(By.xpath(pathToReconnectButton)).getText();
            System.out.println(checkReconnectButtonValue + " 1");


            tStart = System.currentTimeMillis();

            if (checkReconnectButtonValue.equals("reconnect")) {
        //todo need to add time 10 sec
                do {
                    try {
                        driver.findElement(By.xpath(pathToReconnectButton)).click();
                        checkReconnectButtonValue = driver.findElement(By.xpath(pathToReconnectButton)).getText();
                        System.out.println(checkReconnectButtonValue + " 2");

                        long start_time = System.currentTimeMillis();
                        long wait_time = 3000;
                        long end_time = start_time + wait_time;

                        while (System.currentTimeMillis() < end_time) {
                        }

                        tEnd = System.currentTimeMillis();
                        tDelta = tEnd - tStart;
                        elapsedSeconds = tDelta / 1000;

                    } catch (Exception e) {
                        //System.out.println("Button \"reconnect\" doesn't exist");
                    }
                } while (elapsedSeconds < 10 || checkReconnectButtonValue.equals("reconnect"));
                //} while (checkReconnectButtonValue.equals("reconnect"));
                System.out.println(checkReconnectButtonValue + " 3");


            } else {

            }
        } catch (Exception e) {
            //System.out.println("Button \"reconnect\" doesn't exist");
            //logger.modemsLogs('\t' + modem + "\r\n", pathToModemLogFile);
            //logger.modemsLogs('\t' + "No modem detected from Modem_Reconnect                                             " +
                    //"Test failed", pathToModemLogFile);
        }

    }
}
