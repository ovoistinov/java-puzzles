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
        int[][] input = new int[sizeI][sizeJ];
        int[][] weight = new int[sizeI][sizeJ];

        for (int i=0; i < sizeI; i++) {
            for (int j=0; j < sizeJ; j++) {
                input[i][j] = in.nextInt();

                int w = 0;

                if (i > 0 && j > 0) {
                    w = Math.min(weight[i-1][j], weight[i][j-1]);
                } else if (i == 0 && j == 0) {
                    w = 0;
                } else if (i == 0) {
                    w = weight[i][j-1];
                } else if (j == 0) {
                    w = weight[i-1][j];
                }

                weight[i][j] = w + input[i][j];
            }
        }

        out.print(weight[sizeI-1][sizeJ-1]);
    }
}