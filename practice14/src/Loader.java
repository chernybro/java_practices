import java.io.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Loader {
    static Logger logger;
    public static void main(String[] args) {
        createLogFile();
        try {
           logger.log(Level.INFO, " fdfd");
           logger.log(Level.WARNING, "Message with warning");
        } catch (Exception e) {
            e.printStackTrace();
           logger.log(Level.WARNING, "smth wrong");
        }
    }

    public static void createLogFile() {
        File filePath = new File("log");
        filePath.mkdir();
        File logfile = new File(filePath + "\\log.txt");
        try {
            logfile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileOutputStream os = new FileOutputStream("log\\log.txt")) {
            logger = Logger.getLogger(Loader.class.getName());
            FileHandler fileHandler = new FileHandler("log\\log.txt");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
