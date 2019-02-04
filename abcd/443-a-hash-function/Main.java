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

    // Runtime O(n*s)
    // Memory O(n)
    // Min runtime: O(n*s)
    private void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();

        Map<Integer, Integer> hashes = new HashMap<>();

        for (int i=0; i < n; i++) {
            int hash = calcHashHorner(in.next(), x, m);
            hashes.put(hash, hashes.getOrDefault(hash, 0) + 1);
        }

        int result = 0;

        for (Integer count : hashes.values()) {
            if (count >= 2) result += (count*(count-1))/2;
        }

        out.print(result);
    }

    private int calcHashHorner(String s, int x, int m) {
        int len = s.length();
        int sum = 0;

        // Using the Horner's method for calculating polynomials:
        // a * x^3 + b * x^2 + c * x + d = ((a * x + b) * x + c) * x + d
        for (int i=len-1; i >= 0; i--) {
            sum = (sum * x + (s.charAt(i) - '0')) % m;
        }

        return sum;
    }

    // (a+b) mod c = (a mod c + b mod c) mod c
    // (a*b) mod c = (a mod c)*(b mod c) mod c
    private int calcHash(String s, int x, int m) {
        char[] chars = s.toCharArray();

        int sum = 0;
        int pow = 1;

        for (int i=0; i < chars.length; i++) {
            sum += (chars[i] - '0')*pow;
            sum %= m;

            pow *= x;
            pow %= m;
        }

        return sum % m;
    }
}
