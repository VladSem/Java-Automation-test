package com.streambox.fivemodems;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by vlad on 4/15/15.
 */
public class CarrierValidator extends AvenirWebDriver {

    private LogModemsWrite logger = new LogModemsWrite();
    private FindTextOnWebPage carrierDetection = new FindTextOnWebPage();
    //private static String logLine = "\r\n********************************************************************************\r\n";

    private boolean ifPathToCarrierExist;
    private String getCarrier;

    public void checkIfCarrier(String pathToCarrierDetection, String pathToModemLogFile) {

        try {

            getCarrier = driver.findElement(By.xpath(pathToCarrierDetection)).getText();


            if (getCarrier.equals("AT&T")) {

                logger.modemsLogs('\t' + "Carrier: " + getCarrier + "                            " + "Test passed", pathToModemLogFile);

            } else if (getCarrier.equals("T-Mobile")) {

                logger.modemsLogs('\t' + "Carrier: " + getCarrier + "                        " + "Test passed", pathToModemLogFile);

            } else if (getCarrier.equals("Verizon")) {

                logger.modemsLogs('\t' + "Carrier: " + getCarrier + "                      " + "Test passed", pathToModemLogFile);

            } else if (getCarrier.equals("Limited Service")) {

                logger.modemsLogs('\t' + "No Carrier detected" + " (" + getCarrier + ")                         " + "Test failed", pathToModemLogFile);

            } else {

                logger.modemsLogs('\t' + "No Carrier detected                                           " + "Test failed", pathToModemLogFile);

            }
        } catch (Exception e) {
            logger.modemsLogs('\t' + "No Carrier detected                                           " + "Test failed", pathToModemLogFile);

        }
    }

    public void carrierVerification_att_tmob(String pathToCarrierDetection, String pathToModemLogFile) {

        try {
            getCarrier = driver.findElement(By.xpath(pathToCarrierDetection)).getText();

            if (getCarrier.equals("AT&T") || getCarrier.equals("T-Mobile")) {

                logger.modemsLogs('\t' + "SIM Verification: correct                " +
                        "Test passed", pathToModemLogFile);

            } else if (getCarrier.equals("Verizon")) {

                logger.modemsLogs('\t' + "SIM Verification: use \"AT&T\" or \"T-Mobile\"         " +
                        "Test failed", pathToModemLogFile);

            } else if (getCarrier.equals("Limited Service")) {

                logger.modemsLogs('\t' + "SIM Verification: can't verify                                " +
                        "Test failed", pathToModemLogFile);

            } else {

                logger.modemsLogs('\t' + "SIM Verification: can't verify                                " +
                        "Test failed", pathToModemLogFile);
            }
        } catch (Exception e) {

            logger.modemsLogs('\t' + "SIM Verification: can't verify                                " +
                    "Test failed", pathToModemLogFile);
        }

    }

    public void carrierVerification_verizon(String pathToCarrierDetection, String pathToModemLogFile) {

        try {
            getCarrier = driver.findElement(By.xpath(pathToCarrierDetection)).getText();

            if (getCarrier.equals("Verizon")) {
                logger.modemsLogs('\t' + "SIM Verification: correct                " +
                        "Test passed", pathToCarrierDetection);
            } else if (getCarrier.equals("AT&T") || getCarrier.equals("T-Mobile")) {
                logger.modemsLogs('\t' + "SIM Verification: use \"Verizon\"         " +
                        "Test failed", pathToModemLogFile);

            } else if (getCarrier.equals("Limited Service")) {

                logger.modemsLogs('\t' + "SIM Verification: can't verify                                " +
                        "Test failed", pathToModemLogFile);

            } else {

                logger.modemsLogs('\t' + "SIM Verification: can't verify                                " +
                        "Test failed", pathToModemLogFile);
            }
        } catch (Exception e) {

            logger.modemsLogs('\t' + "SIM Verification: can't verify                                " +
                    "Test failed", pathToModemLogFile);
        }
    }

}
