package com.streambox.fivemodems;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vlad on 4/2/15.
 */
public class RunShellCommands {

    private void test() {

        RunShellCommands obj = new RunShellCommands();
        //String domainName = "ip.txt";
        //in mac oxs
        String command = "pwd";
        String command2 = "dir";
        //in windows
        //String command = "ping -n 3 " + domainName;
        String output = obj.executeCommand(command);
        String output2 = obj.executeCommand(command2);
        System.out.println(output);

        try {
            FileUtils.writeStringToFile(new File("/var/www/html/five_modems/apn_and_phone/pwd.txt"), output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileUtils.writeStringToFile(new File("C:\\Users\\manufacture-dell2\\Desktop\\dir.txt"), output2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }
}
