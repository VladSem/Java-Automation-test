package com.streambox.fivemodems;

import java.io.*;


/**
 * Created by vlad on 4/7/15.
 */
public class LogModemsWrite {

    //private static ModemLogHomeDirectory pathToModemLogFile = new ModemLogHomeDirectory();
    //private static String path_to_log_file;

    public static String modemsLogs(String logInfo, String pathToModemsLogFile) {
    //public static String modemsLogs(String logInfo, String pathToModemsLogFile) {

        //Logger logger = Logger.getLogger("MyLog");
        //FileHandler fh;

//        try {

        // This block configure the logger with handler and formatter
        //fh = new FileHandler(pathToModemsLogFile);
        //logger.addHandler(fh);

//            SimpleFormatter formatter = new SimpleFormatter();
//            fh.setFormatter(formatter);

        //fh.setFormatter(new LogFormatter());

        // the following statement is used to log any messages
        //logger.info(logInfo);
        //fh.close();


        // *********************************************************************

//            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter
//                    (new FileOutputStream(pathToModemsLogFile), "utf-8"));
//            try {
//                writer.write(logInfo);
//            } finally {
//                writer.close();
//            }
//
//        } catch (SecurityException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //path_to_log_file = pathToModemLogFile.create_home_directory();

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(pathToModemsLogFile, true)));
            //out.println(logInfo + '\n');
            out.println(logInfo);
            out.close();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
        return logInfo;
    }

//    public static String modemsLogs2(String logInfo, String pathToModemsLogFile) {
//        try {
//            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(pathToModemsLogFile, true)));
//            out.println(logInfo);
//
//            out.close();
//        } catch (IOException e) {
//            //exception handling left as an exercise for the reader
//        }
//
//
//        return logInfo;
//    }
}