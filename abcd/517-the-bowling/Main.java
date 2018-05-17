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

    private void solve(Scanner in, PrintWriter out) {
        int nShots = in.nextInt();

        int[] shot = new int[nShots];

        for (int i=0; i < nShots; i++) {
            shot[i] = in.nextInt();
        }

        int i = 0;
        int score = 0;

        for (int tour = 1; tour <= 10; tour++) {
            if (shot[i] == 10) {
                score += 10 + shot[i+1] + shot[i+2];
                i++;
            } else if (shot[i] + shot[i+1] == 10) {
                score += 10 + shot[i+2];
                i += 2;
            } else {
                score += shot[i] + shot[i+1];
                i += 2;
            }
        }

        out.print(score);
    }
}