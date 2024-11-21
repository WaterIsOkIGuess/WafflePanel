package WafflePanelUpdater;

import com.wafflepanel.wafflepanel.MainSceneBuilder;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import net.kronos.rkon.core.ex.AuthenticationException;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class PanelUpdaterController {


    //public static Object changeProgressBar;

    @FXML
    protected static void changeProgressBar() throws IOException, AuthenticationException {
        //Document doc = Jsoup.connect("https://api.github.com/repos/WaterIsOkIGuess/WafflePanel/releases/latest").get();
        ProgressBar progressBar = (ProgressBar) PanelUpdaterBuilder.fxmlLoader.getNamespace().get("progressBar");

        Timer timer = new Timer();

        TimerTask appDownload = new TimerTask() {
            @Override
            public void run() {
                progressBar.setProgress(0.25);
            }
        };

        TimerTask appUnpacking = new TimerTask() {
            @Override
            public void run() {
                progressBar.setProgress(0.5);
            }
        };

        TimerTask appInstalling = new TimerTask() {
            @Override
            public void run() {
                progressBar.setProgress(0.75);
            }
        };

        TimerTask updaterClose = new TimerTask() {
            @Override
            public void run() {
                Platform.exit();
                System.out.println("awd");
                System.exit(0);

            }
        };


        timer.schedule(appDownload, 5000);
        timer.schedule(appUnpacking, 10000);
        timer.schedule(appInstalling, 15000);
        timer.schedule(updaterClose, 20000);





        //String command = "notepad.exe";

        // Execute the command
        //Process process = Runtime.getRuntime().exec(command);





        //System.out.println(download_url);

        //System.out.println(doc.title());

    }

    public static void update() {
        //FXMLLoader fxmlLoader = new FXMLLoader(MainSceneBuilder.class.getResource("PanelUpdater.fxml"));
        //Parent root = null;


    }



}
