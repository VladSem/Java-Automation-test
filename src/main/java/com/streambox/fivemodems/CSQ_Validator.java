package com.streambox.fivemodems;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import javax.xml.soap.Node;
import javax.xml.xpath.*;
import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by vlad on 4/20/15.
 */
public class CSQ_Validator extends AvenirWebDriver {

    private LogModemsWrite logger = new LogModemsWrite();

    private String checkCSQ;
    //private boolean ifCSQExist;
    //private boolean ifCSQExist2;
    private String csq;
    private String csq_line;
    //private FindTextOnWebPage lastCSQ = new FindTextOnWebPage();
    private boolean ifCSQexist;
    private String checkSIM;
    private String checkSIM2;


    public void checkCSQ(String pathToSimCardDetection, String pathToCSQdetection, String pathToModemLogFile) {


        try {
            checkSIM = driver.findElement(By.xpath(pathToSimCardDetection)).getText();
            if (checkSIM.equals("SIM")) {
//                List<WebElement> myElementList = driver.findElements(By.xpath(pathToCSQdetection));
//                for (WebElement theElement : myElementList) {
//                    csq_line = theElement.getText();
//                }
                csq_line = driver.findElement(By.xpath(pathToCSQdetection)).getText();
                //checkCSQ = csq_line.substring(5, 8);
                //if (checkCSQ.equals("csq")) {
                    csq = csq_line.substring(11, 17);
                    //System.out.println(csq);
                    logger.modemsLogs('\t' + "CSQ: " + csq + "                             " + " Test passed", pathToModemLogFile);
                //} else {
                   // System.out.println("Test failed");
                    //logger.modemsLogs('\t' + "No CSQ detected " + "                                                " + " Test failed", pathToModemLogFile);
                //}
            } else {
                //System.out.println("Test failed");
                logger.modemsLogs('\t' + "No CSQ detected " + "                                             " +
                        " Test failed", pathToModemLogFile);
            }
        } catch (Exception e) {
            //logger.modemsLogs('\t' + "No SIM detected                                                             " + "Test failed", pathToModemLogFile);
            logger.modemsLogs('\t' + "No CSQ detected " + "                                             " +
                    " Test failed", pathToModemLogFile);
        }

    }


}
