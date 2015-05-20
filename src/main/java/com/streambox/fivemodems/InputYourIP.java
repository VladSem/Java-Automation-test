package com.streambox.fivemodems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by vlad on 3/26/15.
 */
public class InputYourIP {

    private static String avenirIP = null;

//    public static boolean validIP (String ip) {
//        try {
//            if (ip == null || ip.isEmpty()) {
//                return false;
//            }
//
//            String[] parts = ip.split( "\\." );
//            if ( parts.length != 4 ) {
//                return false;
//            }
//
//            for ( String s : parts ) {
//                int i = Integer.parseInt( s );
//                if ( (i < 0) || (i > 255) ) {
//                    return false;
//                }
//            }
//            if(ip.endsWith(".")) {
//                return false;
//            }
//
//            return true;
//        } catch (NumberFormatException nfe) {
//            return false;
//        }
//    }



//    public static String getIP() {
//
//        System.out.println("Enter your IP address: ");
//
//        //  open up standard input
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        //  read the username from the command-line; need to use try/catch with the
//        //  readLine() method
//        try {
//            avenirIP = br.readLine();
//
//        } catch (IOException ioe) {
//            System.out.println("Error to read your IP!");
//            System.exit(1);
//        }
//
//            System.out.println("Your IP is: " + avenirIP + ", wait...");
//
//        return avenirIP;
//    }


    //static String text;

    public static String proverka() {
        BufferedReader br = null;
        String sCurrentLine = null;
        try {

            br = new BufferedReader(new FileReader("/var/www/html/five_modems/apn_and_phone/ip.txt"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return sCurrentLine;
    }



}





