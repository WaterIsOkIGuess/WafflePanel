package WafflePanelUpdater;

import com.wafflepanel.wafflepanel.MainSceneBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class PanelUpdaterBuilder extends Application {

    public static FXMLLoader fxmlLoader;

    @Override
    public void start(Stage stage) throws Exception {

        fxmlLoader = new FXMLLoader(MainSceneBuilder.class.getResource("PanelUpdater.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Waffle Panel");
        stage.setResizable(false);
        stage.getIcons().add(new Image(MainSceneBuilder.class.getResourceAsStream("Molly.png")));
        stage.setScene(scene);
        stage.show();




        //Parent root = fxmlLoader.load();
        //ProgressBar progressBar = (ProgressBar) fxmlLoader.getNamespace().get("progressBar");
        //progressBar.setProgress(0.25);

        PanelUpdaterController.changeProgressBar();

        //Thread update = new Thread(new PanelUpdaterController());
        //update.start();
        //ProgressBar progressBar = PanelSceneController.progressBar;
        //progressBar.setProgress(.5);
        //System.out.println();

        //this.wait(5000);

/*
        JSONObject json = readJsonFromUrl("https://api.github.com/repos/WaterIsOkIGuess/WafflePanel/releases/latest");

        String download_url = json.getJSONArray("assets").getJSONObject(0).getString("browser_download_url");
        String fileName = "WafflePanel.jar";


        URL url = new URL(download_url);
        ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        FileChannel fileChannel = fileOutputStream.getChannel();
        fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
  */
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

    public static void main(String[] args) {
        launch();
        //System.out.println("end");

    }
}
