package com.streambox.fivemodems;

import org.openqa.selenium.By;

/**
 * Created by vlad on 4/17/15.
 */
public class ConnectedBandValidator extends AvenirWebDriver {

    private LogModemsWrite logger = new LogModemsWrite();

    private String checkConnectedBand;

    public void checkConnectedBand(String pathToConnectedBandDetection, String pathToModemLogFile) {

        try {

            checkConnectedBand = driver.findElement(By.xpath(pathToConnectedBandDetection)).getText();

            if (checkConnectedBand.equals("(PCS1900)")) {

                logger.modemsLogs('\t' + "Connected Band: PCS1900                  " + "Test passed", pathToModemLogFile);

            } else if (checkConnectedBand.equals("(WCDMA 2100)")) {

                logger.modemsLogs('\t' + "Connected Band: WCDMA 2100               " + "Test passed", pathToModemLogFile);

            } else if (checkConnectedBand.equals("(B13)")) {

                logger.modemsLogs('\t' + "Connected Band: B13                      " + "Test passed", pathToModemLogFile);

            } else if (checkConnectedBand.equals("(WCDMA 1900)")) {

                logger.modemsLogs('\t' + "Connected Band: WCDMA 1900               " + "Test passed", pathToModemLogFile);

            } else if (checkConnectedBand.equals("(WCDMA 850)")) {

                logger.modemsLogs('\t' + "Connected Band: WCDMA 850                " + "Test passed", pathToModemLogFile);

            } else {

                logger.modemsLogs('\t' + "Connected Band: N/A                      " + "Test passed", pathToModemLogFile);
            }
        } catch (Exception e) {

            //logger.modemsLogs('\t' + "No Connected Band detected                                       " + "Test failed", pathToModemLogFile);
            logger.modemsLogs('\t' + "Connected Band: N/A                                           " + "Test failed", pathToModemLogFile);
        }

    }

}
