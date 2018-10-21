import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Map;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        Station[] stations = new Station[n];

        for (int i=0; i < n; i++) {
            String name = in.next();
            int x = in.nextInt();
            int y = in.nextInt();
            int r = in.nextInt();

            stations[i] = new Station(name, x, y, r);
        }

        int xa = in.nextInt();
        int ya = in.nextInt();

        printOutput(out, availableStations(stations, xa, ya));
    }

    private Map<String, Integer> availableStations(Station[] stations, int x, int y) {
        Map<String, Integer> result = new LinkedHashMap<>();

        for (int i=0; i < stations.length; i++) {
            Station station = stations[i];

            if (!result.containsKey(station.name)) {
                result.put(station.name, 0);
            }

            if (available(station, x, y)) {
                result.put(station.name, result.get(station.name) + 1);
            }
        }

        return result;
    }

    private boolean available(Station s, int x, int y) {
        return (s.x - x)*(s.x - x) + (s.y - y)*(s.y - y) <= s.r*s.r;
    }

    private void printOutput(PrintWriter out, Map<String, Integer> availableStations) {
        out.println(availableStations.size());

        for (String name : availableStations.keySet()) {
            out.printf("%s %d %n", name, availableStations.get(name));
        }
    }

    class Station {
        int x;
        int y;
        int r;
        String name;

        public Station(String name, int x, int y, int r) {
            this.name = name;
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
}