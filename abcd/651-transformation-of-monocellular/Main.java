import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

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
        int nInitial = in.nextInt();
        int nTarget = in.nextInt();

        List<Integer> mInitial = getPrimeFactors(nInitial);
        List<Integer> mTarget = getPrimeFactors(nTarget);

        Map<Integer, Integer> uniquePrimeFactors = new HashMap<>();

        for (int factor : mInitial) {
            uniquePrimeFactors.compute(factor, (k, v) -> v == null ? 1 : v+1);
        }

        for (int factor : mTarget) {
            uniquePrimeFactors.compute(factor, (k, v) -> v == null ? -1 : v-1);
        }

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : uniquePrimeFactors.entrySet()) {
            count += Math.abs(entry.getValue());
        }

        out.print(count);
    }

    private List<Integer> getPrimeFactors(int n) {
        List<Integer> set = new ArrayList<>();
        int m = 2;

        while(m * m <= n) {
            if (n % m == 0) {
                n /= m;
                set.add(m);
            } else {
                m++;
            }
        }

        if (n > 1) {
            set.add(n);
        }

        return set;
    }
}