import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeMap;

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
        TreeMap<Integer, Integer> m = new TreeMap<>();

        for (int i=0; i < 5; i++) {
            int n = in.nextInt();
            int count = m.containsKey(n) ? m.get(n) : 0;
            m.put(n, count + 1);
        }

        if (m.size() == 1) {
            out.print("Impossible");
        } else if (m.size() == 2 && m.containsValue(4)) {
            out.print("Four of a Kind");
        } else if (m.size() == 2 && m.containsValue(3)) {
            out.print("Full House");
        } else if (m.size() == 5) {
            int max = m.lastKey();
            int min = m.firstKey();

            if (max - min == 4) {
                out.print("Straight");
            } else {
                out.print("Nothing");
            }
        } else if (m.size() == 3 && m.containsValue(3)) {
            out.print("Three of a Kind");
        } else if (m.size() == 3) {
            out.print("Two Pairs");
        } else if (m.size() == 4) {
            out.print("One Pair");
        } else {
            throw new Error();
        }
    }
}