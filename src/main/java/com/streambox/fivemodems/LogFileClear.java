package com.streambox.fivemodems;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by vlad on 4/13/15.
 */
public class LogFileClear {

    private static ModemLogHomeDirectory modemsLogsHomeDirectory = new ModemLogHomeDirectory();
    private static String pathToModemLogFile;

    public static void clearLogFile() {

        pathToModemLogFile = modemsLogsHomeDirectory.create_home_directory();

        PrintWriter writer = null;
        try {
            writer = new PrintWriter(pathToModemLogFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer.print("");
        writer.close();

    }
}
