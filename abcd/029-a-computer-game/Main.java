import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Math.abs;
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
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int[] num = new int[n];

        for (int i=0; i < n; i++) num[i] = in.nextInt();

        int result;

        if (n < 2) {
            result = 0;
        } else if (n == 2) {
            result = abs(num[1] - num[0]);
        } else {
            int[] energy = new int[n];
            energy[0] = 0;
            energy[1] = abs(num[1] - num[0]);

            for (int i=2; i < num.length; i++) {
                energy[i] = min(
                    energy[i-1] + abs(num[i] - num[i-1]), 
                    energy[i-2] + abs(num[i] - num[i-2])*3
                );
            }

            result = energy[energy.length - 1];
        }

        out.print(result);
    }
}
