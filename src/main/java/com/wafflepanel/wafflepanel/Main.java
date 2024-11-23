package com.wafflepanel.wafflepanel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    public static Logger logger = Logger.getLogger(Main.class.getName());
    public static FileHandler fh;





    public static void main(String[] args) throws IOException {



        createLogger();
        //writeToLogger("gang");
        MainSceneBuilder.main(args);

        JSONObject json = readJsonFromUrl("https://api.github.com/repos/WaterIsOkIGuess/WafflePanel/releases/latest");

        String download_url = json.getJSONArray("assets").getJSONObject(0).getString("browser_download_url");
        String fileName = "PanelUpdater.jar";

        System.out.println(download_url);


        URL url = new URL(download_url);
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        FileChannel fileChannel = fileOutputStream.getChannel();
        fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }



    public static void createLogger() {

        try {
            fh = new FileHandler("latest.txt", true);
            logger.addHandler(fh);
            System.setProperty("java.util.logging.SimpleFormatter.format",
                    "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS %4$s %2$s %5$s%6$s%n");
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void writeToLogger(String message) {
        logger.info(message);
    }






}
