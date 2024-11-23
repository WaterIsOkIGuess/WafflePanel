package WafflePanelUpdater;

import com.wafflepanel.wafflepanel.MainSceneBuilder;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.kronos.rkon.core.ex.AuthenticationException;

import java.io.IOException;

public class PanelUpdaterBuilder extends Application {

    public static FXMLLoader fxmlLoader;

    @Override
    public void start(Stage stage) throws Exception {

        fxmlLoader = new FXMLLoader(MainSceneBuilder.class.getResource("PanelUpdater.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Waffle Panel");
        stage.setResizable(false);
        stage.getIcons().add(new Image(MainSceneBuilder.class.getResourceAsStream("Molly.png")));
        stage.setScene(scene);
        stage.show();

        //Thread downloadStart = new Thread(new updaterRun());
        //downloadStart.start();

        PanelUpdaterController.updateDownload();



        ProgressBar progressBar = (ProgressBar) PanelUpdaterBuilder.fxmlLoader.getNamespace().get("progressBar");
        Label statusLabel = (Label) PanelUpdaterBuilder.fxmlLoader.getNamespace().get("statusLabel");

        statusLabel.setText("Downloading...");

        delay(4000, () -> statusLabel.setText("Unpacking..."));
        delay(4000, () -> progressBar.setProgress(0.25));


        delay(8000, () -> statusLabel.setText("Installing..."));
        delay(8000, () -> progressBar.setProgress(0.5));


        delay(12000, () -> statusLabel.setText("Cleaning up..."));
        delay(12000, () -> progressBar.setProgress(0.75));

        String command;
        delay(16000, this::endUpdate);







        //statusLabel.setText("Updater finished.");





                //Parent root = fxmlLoader.load();
        //ProgressBar progressBar = (ProgressBar) fxmlLoader.getNamespace().get("progressBar");
        //progressBar.setProgress(0.25);



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

    public void endUpdate() {
        Platform.exit();
        String command = "java -jar " + System.getProperty("user.dir") + "\\WafflePanel.jar";
        try {
            Process process = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.exit(0);
    }


    public static void delay(long millis, Runnable continuation) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try { Thread.sleep(millis); }
                catch (InterruptedException e) { }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> continuation.run());
        new Thread(sleeper).start();
    }





    public static void main(String[] args) {
        //PanelUpdaterController.changeProgressBar();
        launch();
        //System.out.println("end");

    }
}
