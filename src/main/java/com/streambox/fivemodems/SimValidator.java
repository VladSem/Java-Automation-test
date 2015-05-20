package com.streambox.fivemodems;

import org.openqa.selenium.By;

/**
 * Created by vlad on 4/14/15.
 */
public class SimValidator extends AvenirWebDriver {

    private LogModemsWrite logger = new LogModemsWrite();
    private String checkSIM;
    private boolean ifSIMExist;

    private ConnectedBandValidator connectedBandValidator = new ConnectedBandValidator();
    private NetworkValidator networkValidator = new NetworkValidator();
    private CarrierValidator carrierValidator = new CarrierValidator();
    private CSQ_Validator csq_validator = new CSQ_Validator();

    private static ModemConnectionValidator modemConnectionValidator = new ModemConnectionValidator();

    public void checkIfSIMinside(String pathToSimCardDetection, String pathToConnectedBandDetection,
                                 String pathToNetworkDetection, String pathToCarrierDetection,
                                 String pathToCSQdetection, String pathToModemConnectionButton,
                                 String pathToModemLogFile) {

        try {

            checkSIM = driver.findElement(By.xpath(pathToSimCardDetection)).getText().trim();
            //ifSIMExist = driver.findElements(By.xpath(pathToSimCardDetection)).size() > 0;

            //System.out.println(checkSIM);
            //System.out.println(ifSIMExist);

            if (checkSIM.equals("SIM")) {
                //logger.modemsLogs('\t' + "SIM inside detected                      " + "Test passed", pathToModemLogFile);

                connectedBandValidator.checkConnectedBand(pathToConnectedBandDetection, pathToModemLogFile);
                networkValidator.checkNetwork(pathToNetworkDetection, pathToModemLogFile);
                carrierValidator.checkIfCarrier(pathToCarrierDetection, pathToModemLogFile);
                csq_validator.checkCSQ(pathToSimCardDetection, pathToCSQdetection, pathToModemLogFile);
                modemConnectionValidator.checkIfModemConnected(pathToModemConnectionButton, pathToModemLogFile);

            } else {
                //logger.modemsLogs('\t' + "No SIM detected                                               " +
                        //"Test failed", pathToModemLogFile);
            }
        } catch (Exception e) {

            ///logger.modemsLogs('\t' + "No SIM detected                                               " +
                    //"Test failed", pathToModemLogFile);
        }

    }

}
