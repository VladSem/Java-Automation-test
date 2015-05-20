package com.streambox.fivemodems;

/**
 * Created by vlad on 4/20/15.
 */
public class APN_and_PhoneNo_Validator {

    private LogModemsWrite logger = new LogModemsWrite();

    private Configuration_for_ATT_and_TMobile configuration_for_att_and_tMobile = new Configuration_for_ATT_and_TMobile();
    private Configuration_for_Verizon configuration_for_verizon = new Configuration_for_Verizon();

    public void att_tmob_validator(String buttonReconnect, String pathToModemLogFile) {

        try {

            configuration_for_att_and_tMobile.set_modem_settings_for_att_tmobile(buttonReconnect);

            if (configuration_for_att_and_tMobile.getAPN.equals("broadband")) {
                logger.modemsLogs('\t' + "APN: " + configuration_for_att_and_tMobile.getAPN + "                           " + "Test passed", pathToModemLogFile);
            } else {
                logger.modemsLogs('\t' + "APN: " + configuration_for_att_and_tMobile.getAPN + "                           " + "Test failed", pathToModemLogFile);
            }

            if (configuration_for_att_and_tMobile.getPhoneNo.equals("")) {
                logger.modemsLogs('\t' + "Phone No: " + configuration_for_att_and_tMobile.getPhoneNo + "                               " + "Test passed", pathToModemLogFile);
            } else {
                logger.modemsLogs('\t' + "Phone No: " + configuration_for_att_and_tMobile.getPhoneNo + "                               " + "Test failed", pathToModemLogFile);
            }
        } catch (Exception e) {
            System.out.println("APN and Phone for ATT something wrong");
        }

    }

    public void verizon_APN_PhoneN_validator(String buttonReconnect, String pathToModemLogFile) {

        try {

            configuration_for_verizon.set_modem_settings_for_verizon(buttonReconnect);

            if (configuration_for_verizon.getAPN.equals("")) {
                logger.modemsLogs('\t' + "APN: " + configuration_for_verizon.getAPN + "                                    " + "Test passed", pathToModemLogFile);
            } else {
                logger.modemsLogs('\t' + "APN: " + configuration_for_verizon.getAPN + "                           " + "Test failed", pathToModemLogFile);
            }

            if (configuration_for_verizon.getPhoneNo.equals("*99***3#")) {
                logger.modemsLogs('\t' + "Phone No: " + configuration_for_verizon.getPhoneNo + "                       " + "Test passed", pathToModemLogFile);
            } else {
                logger.modemsLogs('\t' + "Phone No: " + configuration_for_verizon.getPhoneNo + "                       " + "Test failed", pathToModemLogFile);
            }
        } catch (Exception e) {
            System.out.println("APN and Phone for Verizon something wrong");
        }
    }
}
