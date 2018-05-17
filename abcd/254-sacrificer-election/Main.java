import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

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
        int nCounty = in.nextInt();

        int[] sacrificer = new int[nCounty];

        for (int i=0; i < nCounty; i++) {
            sacrificer[i] = in.nextInt();
        }

        int nReplacements = in.nextInt();

        Map<Integer, Integer> replacements = new HashMap<>();

        for (int i=0; i < nReplacements; i++) {
            int current = in.nextInt();
            int replacement = in.nextInt();
            replacements.put(current, replacement);
        }

        for (int i=0; i < nCounty; i++) {
            int currentSacrificer = sacrificer[i];

            if (replacements.containsKey(currentSacrificer)) {
                out.printf("%d ", replacements.get(currentSacrificer));
            } else {
                out.printf("%d ", currentSacrificer);
            }
        }

    }
}