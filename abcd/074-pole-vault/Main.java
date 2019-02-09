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

    // Runtime O(log(n))
    // Memory O(1)
    // Min runtime: O(log(n))
    private void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();
        int index = in.nextInt();

        // Example:
        //r1-> 1 2 3 4 5 6 7 8 9
        //     y n y n y n y n y
        //r2-> 1   3   5   7   9
        //     y   n   y   n   y
        //r3-> 1       5       9
        //     y       n       y
        //r4-> 1               9
        //     y               n
        //r5-> 1
        //     n
        //
        // 1 goes last.

        int result;

        if (index == 1) {
            result = n;
        } else {
            int lostSportsmen = 0;

            while (index % 2 != 0) {
                // we go to next tour and half (lowered) of them lost
                int lostInRound = n/2;
                lostSportsmen += lostInRound;
                n -= lostInRound;

                index = (index + 1) / 2;
            }

            // if we lost in the round we must count those who lost 
            // before in this round too
            lostSportsmen += index/2;

            result = lostSportsmen;
        }

        out.print(result);
    }
}
