import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solveWithSingularComplexity(in, out);
        }
    }

    private void solveWithSingularComplexity(Scanner in, PrintWriter out) {
        in.useDelimiter(":|\\s+");

        int departureHours = in.nextInt();
        int departureMinutes = in.nextInt();
        int travelHours = in.nextInt();
        int travelMinutes = in.nextInt();

        int departureTime = departureHours * 60 + departureMinutes;
        int travelTime = travelHours * 60 + travelMinutes;
        int arrivalTime = (departureTime + travelTime) % (24 * 60);

        out.printf("%02d:%02d", arrivalTime / 60, arrivalTime % 60);
    }
}