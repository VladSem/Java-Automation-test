package com.streambox.fivemodems;

import java.io.File;
import java.io.IOException;

/**
 * Created by vlad on 4/13/15.
 */
public class ModemLogHomeDirectory {

    static public File path_to_log_file;

    public static String create_home_directory() {

        String home_directory = System.getProperty("user.home");
        //System.out.println(home_directory);

        File folder_directory = new File(home_directory, "./avenir_five_modems_logs");
        folder_directory.mkdir();

        path_to_log_file = new File(folder_directory, "modems.log");
        try {
            path_to_log_file.createNewFile();
            //System.out.println(path_to_log_file);
        } catch (IOException e) {
            // handle error
        }

        return String.valueOf(path_to_log_file);
    }
}
