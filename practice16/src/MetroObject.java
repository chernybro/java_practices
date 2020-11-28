import java.util.ArrayList;
import java.util.HashMap;

public class MetroObject {
    private HashMap<String, String[]> stations;
    private ArrayList<Line> lines;

    public MetroObject(HashMap<String, String[]> stations, ArrayList<Line> lines) {
        this.stations = stations;
        this.lines = lines;
    }

    public HashMap<String, String[]> getStations() {
        return stations;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

}
