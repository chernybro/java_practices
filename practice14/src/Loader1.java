import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Loader1 {
    public static void main(String[] args) {
        Logger logger = logFile();

        Scanner scanner = new Scanner(System.in);
        long size = 0;
        //System.out.println("Введите путь до папки");
        logger.log(Level.INFO,"Введите путь до папки");

        String path = scanner.nextLine();

        logger.log(Level.INFO,path);

        try {
            File file = new File(path);
            if (file.exists()) {
                size = folderSize(file);

                String answer;
                if (size < 1024) {
                    answer = String.valueOf(size) + " Bytes";
                } else if (size < 1024*1024) {
                    answer = String.valueOf(size/1024) + " KB";
                } else if (size < 1024*1024*1024) {
                    answer = String.valueOf(size/(1024*1024)) + " MBytes";
                } else if (size < (long)1024*1024*1024*1024) {
                    answer = String.valueOf(size/(1024*1024*1024)) + " GBytes";
                } else {
                    answer = String.valueOf(size/((long)1024*1024*1024*1024)) + " TBytes";
                }

                //System.out.println("Размер папки " + path + " составляет " + answer);
                logger.log(Level.INFO, "Размер папки " + path + " составляет " + answer);

            } else {
                //System.out.println("Такого каталога нет");
                logger.log(Level.WARNING, "Такого каталога нет");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile())
                length += file.length();
            else if (file.isDirectory())
                length += folderSize(file);
        }
        return length;
    }

    public static Logger logFile() {
        Logger logger = Logger.getLogger(Loader1.class.getName());
        FileHandler fh;

        try {
            fh = new FileHandler("log\\log.txt");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            return logger;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
