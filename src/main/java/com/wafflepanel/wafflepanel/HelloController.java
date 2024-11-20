package com.wafflepanel.wafflepanel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.kronos.rkon.core.Rcon;
import net.kronos.rkon.core.ex.AuthenticationException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws IOException, AuthenticationException {
        Document doc = Jsoup.connect("https://en.wikipedia.org/").get();

        System.out.println(doc.title());

    }


}


/*

// Connects to 127.0.0.1 on port 27015
        Rcon rcon = new Rcon("149.75.163.38", 27015, "123".getBytes());

// Example: On a minecraft server this will list the connected players
        String result = rcon.command("status");

// Display the result in the console
        System.out.println(result);



 */