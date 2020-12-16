package com.company;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        String town = "Moscow";
        String key = "c15d3de9a7b0ec79cc545960878693bb";
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+town+"&appid="+key;

        HttpsURLConnection connection;
        //HttpsURLConnection
        URL u = new URL(url);
        connection = (HttpsURLConnection) u.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(30000);
        connection.connect();
        int status = connection.getResponseCode();
        List<String> lines = new ArrayList<>();
        if(status == 200) {
            Scanner scanner = new Scanner(connection.getInputStream());
            while(scanner.hasNext()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
            System.out.println(lines.toString());
        }

        Path path = Path.of("c:\\123\\weather.txt");
        Files.createFile(path);
        Files.write(path,lines);

        // http://www.jsonschema2pojo.org/ - JSON в описание класса

        //System.out.println(status);
    }
}
