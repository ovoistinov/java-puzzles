import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

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
        String[] dims = in.nextLine().split(" +");
        int iSize = Integer.valueOf(dims[0]);
        int jSize = Integer.valueOf(dims[1]);

        int[][] matrix = new int[iSize][jSize];

        int[] minI = new int[iSize];
        int[] maxJ = new int[jSize];

        Arrays.fill(maxJ, Integer.MIN_VALUE);
        Arrays.fill(minI, Integer.MAX_VALUE);

        for (int i=0; i < iSize; i++) {
            String line = in.nextLine();
            String[] numbers = line.split(" +");

            for (int j=0; j < jSize; j++) {
                matrix[i][j] = Integer.valueOf(numbers[j]);

                maxJ[j] = Math.max(maxJ[j], matrix[i][j]);
                minI[i] = Math.min(minI[i], matrix[i][j]);
            }
        }

        int count = 0;

        for (int i=0; i < iSize; i++) {
            for (int j=0; j < jSize; j++) {
                if (maxJ[j] == minI[i]) {
                    count++;
                }
            }
        }
 
        out.println(count);
    }
}