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
        int sizeI = in.nextInt();
        int sizeJ = in.nextInt();
        int[][] moves = new int[sizeI][sizeJ];

        moves[0][0] = 1;

        for (int i=0; i < sizeI; i++) {
            for (int j=0; j < sizeJ; j++) {
                int step = in.nextInt();

                if (step == 0) {
                    continue;
                }

                if (i+step < sizeI) {
                    moves[i + step][j] += moves[i][j];
                }

                if (j+step < sizeJ) {
                    moves[i][j + step] += moves[i][j];
                }
            }
        }

        out.print(moves[sizeI-1][sizeJ-1]);
    }
}