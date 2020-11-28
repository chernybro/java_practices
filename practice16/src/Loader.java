import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Loader {
    static ArrayList<Line> linesList = new ArrayList<>();
    static HashMap<String, String[]> stationsMap = new HashMap<>();
    static Document html;
    public static void main(String[] args)  {

        html = createHTML();

        addSelectionsListForObjects();

        MetroObject metroObject = new MetroObject(stationsMap,linesList);
        Gson json = new GsonBuilder().setPrettyPrinting().create();

        writeJsonToFile(json, metroObject);

        MetroObject parsedMetroObject = json.fromJson(parseFile(),MetroObject.class);

        ArrayList<Line> parsedList = parsedMetroObject.getLines();
        HashMap<String, String[]> parsedMap = parsedMetroObject.getStations();

        for (var line : parsedList) {
            System.out.println(line.getName() + ". Количество станций - " + parsedMap.get(line.getNumber()).length);
        }
        //System.out.println(json.toJson(metroObject));
    }

    private static void writeJsonToFile(Gson json, MetroObject metroObject) {
        File dir = new File("data");
        if (!dir.exists())
            dir.mkdir();

        FileWriter jsonFile;
        try {
            jsonFile = new FileWriter("data/metro.json");
            jsonFile.write(json.toJson(metroObject));
            jsonFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addSelectionsListForObjects() {
        Elements elLines = html.select("span[data-line]");
        Elements elStations = html.select("div[data-line]");

        for (var item : elLines) {
            Line line = new Line(item.attr("data-line"), item.text());
            linesList.add(line);
        }


        for (var line : linesList) {
            for (var item : elStations) {
                if (line.getNumber().equals(item.attr("data-line"))) {
                    String[] stationsOfLine = item.getElementsByTag("p").text().replaceAll("[^а-яА-ЯёЁъ.\\- ]","").split("\\.");

                    if (stationsOfLine.length - 1 >= 0) System.arraycopy(stationsOfLine, 1, stationsOfLine, 0, stationsOfLine.length - 1);
                    String[] stationsOfLineWDeletedSpaces = new String[stationsOfLine.length];
                    int i = 0;
                    for (String station : stationsOfLine) {
                        station = station.substring(1);
                        if (station.charAt((station.length()) - 1) == ' ') {
                            station = station.substring(0, station.length() - 1);
                        }
                        stationsOfLineWDeletedSpaces[i++] = station;
                    }
                    stationsMap.put(item.attr("data-line"), stationsOfLineWDeletedSpaces);
                    //System.out.println("   " + item.getElementsByTag("p").text().replaceAll("[^а-яА-ЯёЁъ.\\- ]","")); // value that need to split to array
                }
            }
        }
    }

    private static Document createHTML() {
        Document html = null;
        try {
            html = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
       // System.out.println(html.title());
        return html;
    }

    public static String parseFile() {
        StringBuilder builder = new StringBuilder();

        try {
            List<String> files = Files.readAllLines(Paths.get("data/metro.json"));

            files.forEach(line -> builder.append(line).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        return builder.toString();
    }
}
