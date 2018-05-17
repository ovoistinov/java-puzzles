import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Integer.valueOf;
import static java.lang.String.format;

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
        in.nextLine();

        String[] tInfo = new String[n];

        for (int i = 0; i < n; i++) {
            tInfo[i] = in.nextLine();
        }

        int minTravelTime = 1440;
        int minTravelTimeIndex = 0;

        for (int i = 0; i < tInfo.length; i++) {
            int travelTime = travelTimeMins(parseDepartureMins(tInfo[i]), parseArrivalMins(tInfo[i]));

            if (travelTime < minTravelTime) {
                minTravelTime = travelTime;
                minTravelTimeIndex = i;
            }
        }

        out.printf("The fastest train is %s.%n", parseTrainName(tInfo[minTravelTimeIndex]));
        out.printf("It's speed is %d km/h, approximately.", (650*60 + (minTravelTime / 2)) / minTravelTime);
    }

    private String parseTrainName(String tInfo) {
        return tInfo.substring(0, tInfo.lastIndexOf("\"") + 1);
    }

    private int parseDepartureMins(String tInfo) {
        int tIndex = tInfo.lastIndexOf("\"") + 2;
        String[] depTime = tInfo.substring(tIndex, tIndex + 5).split("\\:");
        return valueOf(depTime[0])*60 + valueOf(depTime[1]);
    }

    private int parseArrivalMins(String tInfo) {
        int tIndex = tInfo.lastIndexOf("\"") + 8;
        String[] arrTime = tInfo.substring(tIndex).split("\\:");
        return valueOf(arrTime[0])*60 + valueOf(arrTime[1]);
    }

    private int travelTimeMins(int depMins, int arrMins) {
        if (depMins >= arrMins) {
            return 1440 - depMins + arrMins;
        } else {
            return arrMins - depMins;
        }
    }
}