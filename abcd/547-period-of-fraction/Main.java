import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    private void run() throws Exception {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) throws Exception {
        int d = in.nextInt();

        int[] rPos = new int[d];
        Arrays.fill(rPos, -1);

        int remainder = 1 % d;
        int pos = 0;

        while(true) {
            if (rPos[remainder] != -1) {
                out.printf("%d %d", rPos[remainder], pos - rPos[remainder]);
                return;
            }

            rPos[remainder] = pos;

            remainder *= 10;
            remainder %= d;

            pos++;
        }
    }
}