import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Loader {
    public static void main(String[] args) {
        String srcFolder = "images";
        String dstFolder = "dst";

        File srcDir = new File(srcFolder);

        long start = System.currentTimeMillis();

        File[] files = srcDir.listFiles();

        int threadsCount = Runtime.getRuntime().availableProcessors();
        int arrCount = files.length % threadsCount;
        int newLength = (files.length - arrCount) / threadsCount;
        int srcPos = 0;

        try {
            if (!Files.exists(Paths.get(dstFolder))) {
                Files.createDirectories(Paths.get(dstFolder));
            }
            for (int i = 0; i < threadsCount; i++) {
                File[] threadFile = new File[newLength + 1];

                System.arraycopy(files, srcPos, threadFile, 0, threadFile.length - 1);

                if (arrCount > 0) {
                    System.arraycopy(files, srcPos + threadFile.length, threadFile, threadFile.length, threadFile.length);
                }
                srcPos = threadFile.length + 1;


                Thread thread = new ImageResize(threadFile, dstFolder, start);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*for (int i = 0; i < threadsCount; i++) {
            File[] threadFile = new File[newLength+1];

            System.arraycopy(files, srcPos, threadFile, 0, threadFile.length - 1);

            if (arrCount > 0) {
                System.arraycopy(files,srcPos + threadFile.length, threadFile, threadFile.length, threadFile.length);
            }
            srcPos = threadFile.length + 1;


        }

        try {
            if (!Files.exists(Paths.get(dstFolder))) {
                Files.createDirectories(Paths.get(dstFolder));
            }

            int middle = files.length / 2;
            File[] files1 = new File[middle];

            System.arraycopy(files, 0, files1, 0, files1.length);

            Thread resize1 = new ImageResize(files1, dstFolder, start);
            resize1.start();

            File[] files2 = new File[files.length - middle];

            System.arraycopy(files, middle, files2, 0, files2.length);

            Thread resize2 = new ImageResize(files2, dstFolder, start);
            resize2.start();



        }catch (Exception e){
            e.printStackTrace();
        } */

    }
}
