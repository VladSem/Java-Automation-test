package com.streambox.fivemodems;

import org.openqa.selenium.By;

/**
 * Created by vlad on 4/7/15.
 */
public class ModemsPattern extends AvenirWebDriver {

    private LogModemsWrite logger = new LogModemsWrite();
    private FindTextOnWebPage modemFirmware = new FindTextOnWebPage();
    private FindTextOnWebPage findText = new FindTextOnWebPage();
    private boolean ifConfigButtonExist;

    private boolean firmware_att_tmobile_MC7710_US_03_05_24_00AP;

    private String modemName;
    private String getModemName;

    private String firmware1;
    private String firmware2;

    private APN_and_PhoneNo_Validator apn_and_phoneNo_validator = new APN_and_PhoneNo_Validator();
    private ModemName_IMEI_Firmware_Validator modemNameValidator = new ModemName_IMEI_Firmware_Validator();

    CarrierValidator carrierValidator = new CarrierValidator();

    private static String logLine = "\r\n********************************************************************************\r\n";
    private static String pathToNoModemsDetected = ".//*[@id='mlarea']/span";
    private static String checkIfModemsDetected;

    public void setModemsPatternSettings(String imeiPath, String modemNamePath, String pathToModemLogFile, String modem,
                                         String buttonConfig, String buttonTerminate, String buttonReconnect, String pathToCarrierDetection) {

        try {

//            checkIfModemsDetected = driver.findElement(By.xpath(pathToNoModemsDetected)).getText();
//
//                if (checkIfModemsDetected.equals("- No Modems Detected -")) {
//                    logger.modemsLogs("\t\t\t" + "No Modems Detected(-avenir webdriver) - " + "Test failed\r\n", pathToModemLogFile);
//                    logger.modemsLogs(logLine, pathToModemLogFile);
//                    LogFileForOS openLogFile = new LogFileForOS();
//                    openLogFile.showLogFile();
//                    driver.close();
//
//                } else {
//                }


            //ifConfigButtonExist = driver.findElements(By.xpath(buttonConfig)).size() > 0;
            String configButton = driver.findElement(By.xpath("html/body/div[4]/center/div/table/tbody/tr[5]/td[9]/a[1]")).getText();

            //if (ifConfigButtonExist) {
            if (configButton.equals("config")) {

                //driver.findElement(By.xpath(buttonConfig)).click();
                driver.findElement(By.xpath(buttonConfig)).click();

                firmware_att_tmobile_MC7710_US_03_05_24_00AP = modemFirmware.checkText("SWI9200X_03.05.24.00ap");

                if (firmware_att_tmobile_MC7710_US_03_05_24_00AP) {

                    modemName = "MC7710";
                    firmware1 = "03.05.24.00AP";
                    firmware2 = "";
                    logger.modemsLogs('\t' + modem + "\r\n", pathToModemLogFile);
                    modemNameValidator.check_modem_name(imeiPath, modemName, modemNamePath, firmware1, firmware2, pathToModemLogFile);
                    apn_and_phoneNo_validator.att_tmob_validator(buttonReconnect, pathToModemLogFile);

                    carrierValidator.carrierVerification_att_tmob(pathToCarrierDetection, pathToModemLogFile);

                } else {
                    System.out.println("no button config");
                }


            } else if (configButton.equals("terminate")) {
//todo need to fix terminate button
                    //driver.findElement(By.xpath(buttonTerminate)).click();
                    driver.findElement(By.xpath(buttonTerminate)).click();
                    driver.findElement(By.xpath(buttonConfig)).click();

                firmware_att_tmobile_MC7710_US_03_05_24_00AP = modemFirmware.checkText("SWI9200X_03.05.24.00ap");

                if (firmware_att_tmobile_MC7710_US_03_05_24_00AP) {

                        modemName = "MC7710";
                        firmware1 = "03.05.24.00AP";
                        firmware2 = "";
                        logger.modemsLogs('\t' + modem + "\r\n", pathToModemLogFile);
                        modemNameValidator.check_modem_name(imeiPath, modemName, modemNamePath, firmware1, firmware2, pathToModemLogFile);
                        apn_and_phoneNo_validator.att_tmob_validator(buttonReconnect, pathToModemLogFile);

                        carrierValidator.carrierVerification_att_tmob(pathToCarrierDetection, pathToModemLogFile);

                    } else {
                        System.out.println("no button terminate");
                    }

            } else {
                        System.out.println("modems pattern need to fix");
                    }

        } catch (Exception e) {

            //logger.modemsLogs('\t' + "Try again, something wrong                                    " + "Test failed", pathToModemLogFile);
            //logger.modemsLogs("\t" + modem, pathToModemLogFile);
        }

    }

}
