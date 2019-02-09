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

    // Runtime: O(log(n))
    // Memory: O(log(n))
    // Min runtime: O(log(n))
    private void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        Map<Integer,Integer> cache = new HashMap<>();

        out.print(count(n, cache));
    }

    private int count(int n, Map<Integer,Integer> cache) {
        if (n < 3) return 0;
        if (n == 3) return 1;
        if (cache.containsKey(n)) return cache.get(n);

        cache.put(n, count(n/2, cache) + count((n+1)/2, cache));

        return cache.get(n);
    }
}
