import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.NavigableMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solveLightweight(in, out);
        }
    }

    private void solveLightweight(Scanner in, PrintWriter out) {
        int x[] = new int[5];
        int y[] = new int[5];

        for (int i=0; i < 5; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        int hits = 0;

        for (int t=0; t <=100; t+=25) {
            for (int j=0; j < 5; j++) {
                int d2 = (x[j] - t)*(x[j] - t) + y[j]*y[j];

                if (d2 <= 100) {
                    hits++;
                    break;
                }
            }
        }

        out.print(hits);
    }

    private void solveHeavy(Scanner in, PrintWriter out) {
        int x[] = new int[5];
        int y[] = new int[5];

        for (int i=0; i < 5; i++) {
            x[i] = in.nextInt();
            y[i] = in.nextInt();
        }

        NavigableMap<Integer, Integer> range = new TreeMap<>();
        range.put(-10, 0);
        range.put(15, 25);
        range.put(40, 50);
        range.put(65, 75);
        range.put(90, 100);

        Set<Integer> hits = new HashSet<>();

        for (int i=0; i < 5; i++) {
            Map.Entry<Integer, Integer> entry = range.floorEntry(x[i]);

            if (entry != null) {
                int x2 = entry.getValue();
                int d2 = (x[i] - x2)*(x[i] - x2) + y[i]*y[i];

                if (d2 <= 100) {
                    hits.add(x2);
                }
            }
        }

        out.print(hits.size());
    }
}