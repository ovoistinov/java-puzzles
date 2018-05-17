import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.min;
import static java.lang.Math.max;

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
        int sizeI = in.nextInt();
        int sizeJ = in.nextInt();

        char[][] cell = new char[sizeI][sizeJ];

        for (int i=0; i < sizeI; i++) {
            String s = in.next();
            for (int j=0; j < s.length(); j++) {
                cell[i][j] = s.charAt(j);
            }
        }

        int minI = sizeI;
        int maxI = 0;
        int minJ = sizeJ;
        int maxJ = 0;

        for (int i=0; i < sizeI; i++) {
            for (int j=0; j < sizeJ; j++) {
                char c = cell[i][j];

                if (c == '*') {
                    minI = min(minI, i);
                    maxI = max(maxI, i);
                    minJ = min(minJ, j);
                    maxJ = max(maxJ, j);
                }
            }
        }

        for (int i=minI; i <= maxI; i++) {
            for (int j=minJ; j <= maxJ; j++) {
                cell[i][j] = '*';
            }
        }

        for (int i=0; i < sizeI; i++) {
            for (int j=0; j < sizeJ; j++) {
                out.print(cell[i][j]);
            }

            out.println();
        }
    }
}