package com.wafflepanel.wafflepanel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.kronos.rkon.core.ex.AuthenticationException;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public class SceneController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException, AuthenticationException {
        //Document doc = Jsoup.connect("https://api.github.com/repos/WaterIsOkIGuess/WafflePanel/releases/latest").get();



        String command = "notepad.exe";

        // Execute the command
        Process process = Runtime.getRuntime().exec(command);





        //System.out.println(download_url);

        //System.out.println(doc.title());

    }




}


/*

// Connects to 127.0.0.1 on port 27015


// Example: On a minecraft server this will list the connected players
        String result = rcon.command("status");

// Display the result in the console
        System.out.println(result);



 */