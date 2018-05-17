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
        int n = in.nextInt();

        int[][] edge = new int[n][n];

        for (int i=0; i < n; i++) {
            for (int j=0; j < n; j++) {
                edge[i][j] = in.nextInt();
            }
        }

        int minPath = 3000;

        for (int i=0; i < n-2; i++) {
            for (int j=i+1; j < n-1; j++) {
                for (int k=j+1; k < n; k++) {
                    minPath = Math.min(minPath, edge[i][j] + edge[j][k] + edge[k][i]);
                }
            }
        }

        out.print(minPath);
    }
}