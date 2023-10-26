package org.example.proxyservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RoundRobinPetition {
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String[] servers = {"52.91.87.166", "54.224.65.195"};
    private static int robinCount = 0;

    public static String makePetition(String value) throws IOException {
        URL obj = new URL(getUrl(Integer.parseInt(value)));
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response);
            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");

        return value;
    }

    private static String getUrl(int value){
        return String.format("http://%s:%d/lucasseq?value=%d", getRoundRobinIp(), getMathPort(), value);
    }

    private static String getRoundRobinIp(){
        if (robinCount == servers.length){
            robinCount = 0;
        }
        String server = servers[robinCount];
        robinCount++;
        return server;
    }

    private static int getMathPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080;
    }
}
