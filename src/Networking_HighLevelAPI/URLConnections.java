package Networking_HighLevelAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnections {

    public static void main(String[] args) {

        try {
            URL url = new URL("https://carogi.com");
            URLConnection urlConnection = url.openConnection();
            urlConnection.setDoInput(true);
            urlConnection.connect();

            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream()));

            String line = "";
            while(line != null) {
                line = inputStream.readLine();
                System.out.println(line);
            }
            inputStream.close();

        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

//        try {
//            URL url = new URL("https://carogi.com");
//
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(url.openStream()));
//
//            String line = "";
//            while(line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();
//
//        } catch(IOException e) {
//            System.out.println("IOException: " + e.getMessage());
//        }

    }

}
