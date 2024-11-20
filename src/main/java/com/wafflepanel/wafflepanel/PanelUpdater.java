package com.wafflepanel.wafflepanel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public class PanelUpdater {

    public static void main(String[] args) throws IOException {
        JSONObject json = readJsonFromUrl("https://api.github.com/repos/WaterIsOkIGuess/WafflePanel/releases/latest");

        String download_url = json.getJSONArray("assets").getJSONObject(0).getString("browser_download_url");
        String fileName = "WafflePanel.jar";


        URL url = new URL(download_url);
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        FileChannel fileChannel = fileOutputStream.getChannel();
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

}
