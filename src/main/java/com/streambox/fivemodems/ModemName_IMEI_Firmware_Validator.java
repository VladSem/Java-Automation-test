package com.streambox.fivemodems;

/**
 * Created by vlad on 4/20/15.
 */
public class ModemName_IMEI_Firmware_Validator {

    private FindTextOnWebPage findText = new FindTextOnWebPage();
    private LogModemsWrite logger = new LogModemsWrite();
    private String imeiNumber;

    private String getModemName;
    private String result_Modem_Firmware;


    public void check_modem_name(String imeiPath, String modemName, String modemNamePath, String firmware1,
                                 String firmware2, String pathToModemLogFile) {

        getModemName = findText.checkString(modemNamePath);
        imeiNumber = findText.checkString(imeiPath);

        if (getModemName.equals(modemName)) {
            result_Modem_Firmware = "                  Test passed";
        } else {
            result_Modem_Firmware = "          Test failed" + ". Use " + firmware1 + firmware2;
        }
        logger.modemsLogs('\t' + "Name: " + modemName, pathToModemLogFile);
        logger.modemsLogs('\t' + "IMEI: " + imeiNumber, pathToModemLogFile);
        logger.modemsLogs('\t' + "Firmware: " + firmware1 + result_Modem_Firmware, pathToModemLogFile);
    }

}
