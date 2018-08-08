package Networking_HighLevelAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

// MAY WANT TO TRY JETTY OR APACHE HTTP CLIENT

// APACHE HTTP CLIENT :
//CloseableHttpClient httpClient = HttpClients.createDefault;
//HttpGet request = new HttpGet(website);
//request.addHeader("User-Agent", "Chrome");
//
//CloseableHttpResponse response = httpClient.execute(request);
//print ("response code " + response.getstatusline().getstatuscode())
//
//use inputstreamReader(response.getentity().getcontent) to put into buffered reader

public class UsingHttpURLConnection {
    public static void main(String[] args) {

        try {
            //URL url = new URL("https://carogi.com");
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cats");

            // Using HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set headers
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");

            connection.setReadTimeout(5000);
            int responseCode = connection.getResponseCode();
            System.out.println("Response: " + responseCode);

            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line = "";
            while((line = inputReader.readLine()) != null) {
                System.out.println(line);
            }


                // For printing the headers, using urlConnection
//            urlConnection.setDoInput(true);
//            urlConnection.connect();
//
//            BufferedReader inputStream = new BufferedReader(
//                    new InputStreamReader(urlConnection.getInputStream()));
//
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for(Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("Key: " + key);
//                for(String string: value) {
//                    System.out.println("Value: " + value);
//                }
//            }
                // For printing the xml
//            String line = "";
//            while(line != null) {
//                line = inputStream.readLine();
//                System.out.println(line);
//            }

//            inputStream.close();

        } catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
