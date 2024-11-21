package com.wafflepanel.wafflepanel;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    public static Logger logger = Logger.getLogger(Main.class.getName());
    public static FileHandler fh;





    public static void main(String[] args) {

        createLogger();
        //writeToLogger("gang");
        MainSceneBuilder.main(args);

    }



    public static void createLogger() {

        try {
            fh = new FileHandler("latest.log");
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
