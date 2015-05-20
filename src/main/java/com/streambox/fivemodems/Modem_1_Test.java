package com.streambox.fivemodems;


/**
 * Created by vlad on 3/25/15.
 */

public class Modem_1_Test extends AvenirWebDriver {

    private ModemsPattern modemsPattern = new ModemsPattern();
    private String modem = "Modem #1";

    private String imeiPath = ".//*[@id='modemconf']/tbody/tr/td[2]/table/tbody/tr/td/div/span[5]";
    private String modemNamePath = ".//*[@id='modemconf']/tbody/tr/td[2]/table/tbody/tr/td/div/span[2]";

    private String buttonConfig = "//td[9]/a";
    //private String buttonTerminate = "//td[9]/a";
    private String buttonTerminate = "html/body/div[4]/center/div/table/tbody/tr[1]/td[9]/a[1]";
    private String buttonReconnect = "//td[9]/a[2]";

    private ModemLogHomeDirectory modemsLogsHomeDirectory = new ModemLogHomeDirectory();
    private String pathToModemLogFile;

    private SimValidator simValidator = new SimValidator();
    private String pathToSimCardDetection = "html/body/div[4]/center/div/table/tbody/tr[2]/td[3]/span";

    private String pathToCarrierDetection = "html/body/div[4]/center/div/table/tbody/tr[2]/td[3]/font[1]";

    private String pathToConnectedBandDetection = "html/body/div[4]/center/div/table/tbody/tr[2]/td[3]/font[2]";

    private String pathToNetworkDetection = "html/body/div[4]/center/div/table/tbody/tr[2]/td[3]/font[2]";

    private String pathToCSQdetection = "//tr[2]/td[contains(text(),'last')]";

    private String pathToModemConnectionButton = "html/body/div[4]/center/div/table/tbody/tr[1]/td[8]";

    Modem_Reconnect modem_reconnect = new Modem_Reconnect();
    private String pathToReconnectButton = "html/body/div[4]/center/div/table/tbody/tr[1]/td[9]/a[2]";

    LogModemsWrite logger = new LogModemsWrite();
    String logLine = "\r\n********************************************************************************\r\n";

    public void setModemSettings() {

        pathToModemLogFile = modemsLogsHomeDirectory.create_home_directory();
        modemsPattern.setModemsPatternSettings(imeiPath, modemNamePath, pathToModemLogFile, modem,
                buttonConfig, buttonTerminate, buttonReconnect, pathToCarrierDetection);
        modem_reconnect.clickReconnectMissingModems(pathToReconnectButton, modem, pathToModemLogFile);
        simValidator.checkIfSIMinside(pathToSimCardDetection, pathToConnectedBandDetection, pathToNetworkDetection,
                pathToCarrierDetection, pathToCSQdetection, pathToModemConnectionButton, pathToModemLogFile);

        //logger.modemsLogs(logLine, pathToModemLogFile);



    }
}
