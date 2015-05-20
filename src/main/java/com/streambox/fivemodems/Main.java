package com.streambox.fivemodems;

/**
 * Created by vlad on 3/25/15.
 */
public class Main extends AvenirWebDriver{

    private static AvenirWebDriver avenirWebDriver = new AvenirWebDriver();

    private static Modem_1_Test modem1 = new Modem_1_Test();
    private static Modem_2_Test modem2 = new Modem_2_Test();
    private static Modem_3_Test modem3 = new Modem_3_Test();

    private static LogFileClear clearLogFile = new LogFileClear();
    private static ModemLogHomeDirectory modemsLogsHomeDirectory = new ModemLogHomeDirectory();
    private static String pathToModemLogFile;
    private static LogModemsWrite logger = new LogModemsWrite();
    private static String logLine = "\r\n********************************************************************************\r\n";


    public static void main(String args[]) {


        pathToModemLogFile = modemsLogsHomeDirectory.create_home_directory();
        clearLogFile.clearLogFile();

        avenirWebDriver.setIPforAvenir();

        modem1.setModemSettings();
        logger.modemsLogs(logLine, pathToModemLogFile);

        modem2.setModemSettings();
        logger.modemsLogs(logLine, pathToModemLogFile);

        modem3.setModemSettings();
        logger.modemsLogs(logLine, pathToModemLogFile);

        Modem_4_Test modem4 = new Modem_4_Test();
        modem4.setModemSettings();
        logger.modemsLogs(logLine, pathToModemLogFile);

        Modem_5_Test modem5 = new Modem_5_Test();
        modem5.setModemSettings();
        logger.modemsLogs(logLine, pathToModemLogFile);

        //Modem_Reconnect modem_reconnect = new Modem_Reconnect();
        //modem_reconnect.clickReconnectMissingModems();

        VideoSignalValidator videoSignalValidator = new VideoSignalValidator();
        videoSignalValidator.checkVideoSignal();

        //driver.close();

        LogFileForOS openLogFile = new LogFileForOS();
        openLogFile.showLogFile();

    }



}






