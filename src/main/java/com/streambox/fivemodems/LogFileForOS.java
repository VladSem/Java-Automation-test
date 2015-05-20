package com.streambox.fivemodems;

import java.io.IOException;

/**
 * Created by vlad on 4/13/15.
 */
public class LogFileForOS extends ModemLogHomeDirectory {

    public static void showLogFile() {

        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            try {
                Runtime.getRuntime().exec("notepad " + path_to_log_file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (System.getProperty("os.name").toLowerCase().contains("linux")) {
            try {
                Runtime.getRuntime().exec("gedit " + path_to_log_file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            try {
                Runtime.getRuntime().exec("/usr/bin/open -a TextEdit " + path_to_log_file);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
