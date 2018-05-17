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

        int[][] sudoku = new int[n*n + 1][n*n + 1];

        for (int i=1; i <= n*n; i++) {
            for (int j=1; j <= n*n; j++) {
                sudoku[i][j] = in.nextInt();
            }
        }

        boolean[] usedRow;
        boolean[] usedCol;

        for (int i=1; i <= n*n; i++) {
            usedRow = new boolean[101];
            usedCol = new boolean[101];

            for (int j=1; j <= n*n; j++) {
                usedRow[sudoku[i][j]] = true;
                usedCol[sudoku[j][i]] = true;
            }

            if (hasMissingNumbers(usedRow, n*n) || hasMissingNumbers(usedCol, n*n)) {
                out.println("Incorrect");
                return;
            }
        }

        for (int i=1; i <= n; i++) {
            for (int j=1; j <= n; j++) {
                boolean[] used = new boolean[101];

                int fromii = (i-1)*n + 1;
                int toii = i*n;
                int fromjj = (j-1)*n + 1;
                int tojj = j*n;

                for (int ii=fromii; ii <= toii; ii++) {
                    for (int jj=fromjj; jj <= tojj; jj++) {
                        used[sudoku[ii][jj]] = true;
                    }
                }

                if (hasMissingNumbers(used, n*n)) {
                    out.print("Incorrect");
                    return;
                }
            }
        }

        out.print("Correct");
    }

    private boolean hasMissingNumbers(boolean[] used, int n) {
        for (int i=1; i <= n; i++) {
            if (!used[i]) {
                return true;
            }
        }

        return false;
    }
}