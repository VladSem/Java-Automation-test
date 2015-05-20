package com.streambox.fivemodems;

import org.openqa.selenium.By;

/**
 * Created by vlad on 4/17/15.
 */
public class NetworkValidator extends AvenirWebDriver{

    private LogModemsWrite logger = new LogModemsWrite();
    private String checkNetwork;

    public void checkNetwork(String pathToNetworkDetection, String pathToModemLogFile) {

        try {

            checkNetwork = driver.findElement(By.xpath(pathToNetworkDetection)).getText();
            System.out.println(checkNetwork);

            if (checkNetwork.equals("(LTE/E-UTRAN)")) {

                logger.modemsLogs('\t' + "Network: LTE/E-UTRAN                     " + "Test passed", pathToModemLogFile);

            } else if (checkNetwork.equals("(GSM)")) {

                    logger.modemsLogs('\t' + "Network: GSM                             " + "Test passed", pathToModemLogFile);

            } else if (checkNetwork.equals("(UTRAN)")) {

                logger.modemsLogs('\t' + "Network: UTRAN                           " + "Test passed", pathToModemLogFile);

            } else if (checkNetwork.equals("(LTE)")) {

                logger.modemsLogs('\t' + "Network: LTE                             " + "Test passed", pathToModemLogFile);

            } else if (checkNetwork.equals("(WCDMA)")) {

                logger.modemsLogs('\t' + "Network: WCDMA                           " + "Test passed", pathToModemLogFile);

            } else {

                logger.modemsLogs('\t' + "No Network detected                                           " + "Test failed", pathToModemLogFile);

            }
        } catch (Exception e) {

            logger.modemsLogs('\t' + "No Network detected                                           " + "Test failed", pathToModemLogFile);

        }

    }

}
