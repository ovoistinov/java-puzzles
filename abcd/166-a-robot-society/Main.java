import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

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
        int k = in.nextInt();
        int years = in.nextInt();

        int[] robots = new int[years+1];
        robots[1] = k;

        buildPopulation(robots, years);

        out.print(countRobotsForYear(robots, years));
    }

    private void buildPopulation(int[] robots, int years) {
        for (int i=2; i <= years; i++) {
            int existingRobots = 0;

            for (int j=i-1; j>= i-3 && j>=1; j--) {
                existingRobots += robots[j];
            }

            robots[i] = buildNewRobots(existingRobots);
        }
    }

    private int buildNewRobots(int sum) {
        int max = 0;

        for (int i=0; i*3 <= sum && i < 5; i++) {
            int a = (sum - i*3) / 5;
            max = Math.max(max, i*5 + a*9);
        }

        return max;
    }

    private int countRobotsForYear(int robots[], int year) {
        int result = 0;

        for (int i=year; i >= year-2 && i >= 1; i--) {
            result += robots[i];
        }

        return result;
    }
}