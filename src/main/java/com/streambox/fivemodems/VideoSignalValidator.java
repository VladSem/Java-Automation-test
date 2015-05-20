package com.streambox.fivemodems;

import org.openqa.selenium.By;

/**
 * Created by vlad on 4/28/15.
 */
public class VideoSignalValidator extends AvenirWebDriver{

    private LogModemsWrite logger = new LogModemsWrite();
    private String checkVideoSignal;

    private String pathToVideoSignalDetection = "html/body/div[3]/div[6]/span[2]";

    private ModemLogHomeDirectory modemsLogsHomeDirectory = new ModemLogHomeDirectory();
    private String pathToModemLogFile;

    public void checkVideoSignal() {


        pathToModemLogFile = modemsLogsHomeDirectory.create_home_directory();

        try {

            checkVideoSignal = driver.findElement(By.xpath(pathToVideoSignalDetection)).getText().trim();

            if (checkVideoSignal.equals("NO VIDEO *")) {
                logger.modemsLogs("\t" + "NO VIDEO SIGNAL detected " + "                                    " +
                        " Test failed", pathToModemLogFile);
            } else {

                logger.modemsLogs('\t' + "VIDEO SIGNAL Verification: can't verify                       " +
                        "Test failed", pathToModemLogFile);
            }

        } catch (Exception e) {
            logger.modemsLogs('\t' + "VIDEO SIGNAL Verification: can't verify                       " +
                    "Test failed", pathToModemLogFile);
        }
    }
}
