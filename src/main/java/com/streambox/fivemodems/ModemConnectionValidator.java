package com.streambox.fivemodems;


import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


/**
 * Created by vlad on 4/20/15.
 */
public class ModemConnectionValidator extends AvenirWebDriver {

    private LogModemsWrite logger = new LogModemsWrite();
    private String checkButtonConnected;
    private String checkButtonConnected4;

    private long tStart;
    private long tEnd;
    private long tDelta;
    private static long elapsedSeconds;

//    private long hours;
//    private long minutes;
//    private long seconds;
//    private String timeString;

    private long start;
    private long elapsed;
    private String seconds;

    public void checkIfModemConnected(String pathToModemButtonDetection, String pathToModemLogFile) {

        checkButtonConnected = driver.findElement(By.xpath(pathToModemButtonDetection)).getText();
        start = System.currentTimeMillis(); //new
        tStart = System.currentTimeMillis();

        if (checkButtonConnected.equals("Connected")) {

            elapsed = System.currentTimeMillis() - start;
            DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");
            df.setTimeZone(TimeZone.getTimeZone("GMT+0"));
            seconds = df.format(new Date(elapsed)); //sam dobavil
            logger.modemsLogs("\r\n\t" + "Modem staus: " + checkButtonConnected4 + " - It took " +
                    seconds + "     " + "Test passed", pathToModemLogFile);

//        } else if (checkButtonConnected.equals("con-phase2")) {

        } else if (checkButtonConnected.equals("retrying") || checkButtonConnected.equals("connecting") ||
        checkButtonConnected.equals("con-phase2")) {

            int time = 0;

            do {

                try {

                    long start_time = System.currentTimeMillis();
                    long wait_time = 5000;
                    long end_time = start_time + wait_time;

                    while (System.currentTimeMillis() < end_time) {
                    }

                    checkButtonConnected4 = driver.findElement(By.xpath(pathToModemButtonDetection)).getText();
                    //System.out.println(checkButtonConnected4);

                    System.out.println(time + ": time(s)");
                    time += 1;

                    tEnd = System.currentTimeMillis();
                    tDelta = tEnd - tStart;
                    elapsedSeconds = tDelta / 1000;
                    System.out.println(elapsedSeconds);

                    elapsed = System.currentTimeMillis() - start;
                    DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");
                    df.setTimeZone(TimeZone.getTimeZone("GMT+0"));
                    seconds = df.format(new Date(elapsed)); //sam dobavil
                    System.out.println(seconds);

                    logger.modemsLogs("\r\n\t" + "Modem staus: " + checkButtonConnected4 + " - It took " +
                            seconds + "     " + "Test in process", pathToModemLogFile);

                } catch (Exception e) {
                    elapsed = System.currentTimeMillis() - start;
                    DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");
                    df.setTimeZone(TimeZone.getTimeZone("GMT+0"));
                    seconds = df.format(new Date(elapsed)); //sam dobavil
                    System.out.println("retrying ... -> " + checkButtonConnected4 + " " + seconds);
                    logger.modemsLogs("\r\n\t" + "Modem staus: " + checkButtonConnected4 + " - It took " +
                            seconds + "     " + "Test failed", pathToModemLogFile);
                }

//            } while (checkButtonConnected4.equals("retrying") || checkButtonConnected4.equals("connecting") ||
//                    checkButtonConnected4.equals("con-phase2") && elapsedSeconds < 5);
        } while (elapsedSeconds < 40 & checkButtonConnected4.equals("retrying") ||
                    checkButtonConnected4.equals("connecting") || checkButtonConnected4.equals("con-phase2"));

            elapsed = System.currentTimeMillis() - start;
            DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");
            df.setTimeZone(TimeZone.getTimeZone("GMT+0"));
            seconds = df.format(new Date(elapsed)); //sam dobavil
            System.out.println(seconds);

            //checkButtonConnected4 = driver.findElement(By.xpath(pathToModemButtonDetection)).getText();
            if (checkButtonConnected4.equals("retrying") || checkButtonConnected4.equals("connecting") ||
                    checkButtonConnected4.equals("con-phase2")) {

                logger.modemsLogs("\r\n\t" + "Modem staus: " + checkButtonConnected4 + " - It took " +
                        seconds + "     " + "Test failed", pathToModemLogFile);
            } else {

                logger.modemsLogs("\r\n\t" + "Modem staus: " + checkButtonConnected4 + " - It took " +
                        seconds + "     " + "Test passed", pathToModemLogFile);
            }

        } else {
            logger.modemsLogs("\r\n\t" + "Modem status1: " + checkButtonConnected +
                    "                                    " + "Test failed", pathToModemLogFile);
        }

    }

}
