package com.streambox.fivemodems;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by vlad on 4/24/15.
 */
public class TimeValidator {

    private long elapsed;
    //private String seconds;

    private ModemLogHomeDirectory modemsLogsHomeDirectory = new ModemLogHomeDirectory();
    private String pathToModemLogFile;

    private LogModemsWrite logger = new LogModemsWrite();


    public String timevalidator(long start) {

        pathToModemLogFile = modemsLogsHomeDirectory.create_home_directory();

        elapsed = System.currentTimeMillis() - start;
        DateFormat df = new SimpleDateFormat("HH 'hours', mm 'mins,' ss 'seconds'");
        df.setTimeZone(TimeZone.getTimeZone("GMT+0"));
        String seconds = df.format(new Date(elapsed)); //sam dobavil
        logger.modemsLogs("\r\n\t" + "Total Time: " + seconds, pathToModemLogFile);

        //return seconds;
        return seconds;
    }
}
