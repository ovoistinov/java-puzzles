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
        int d = in.nextInt();

        Map<Integer, Integer> remainders = new HashMap<>();

        int remainder = 1 % d * 10;

        if (remainder == 0) {
            out.print("0 0");
            return;
        }

        int prefixLength = 0;
        int fractionLength = 0;

        while(true) {
            if (remainder == 0) {
                fractionLength = 1;
                break;
            }

            if (remainders.containsKey(remainder)) {
                fractionLength = prefixLength - remainders.get(remainder);
                prefixLength -= fractionLength;

                break;
            }

            remainders.put(remainder, prefixLength);
            remainder %= d;
            remainder *= 10;

            prefixLength++;
        }

        out.print(prefixLength);
        out.print(' ');
        out.print(fractionLength);
    }
}