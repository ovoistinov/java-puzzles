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

    // Runtime: O(n^2)
    // Memory: O(n^2)
    // Min runtime: O(n^2)
    private void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        int[][] m = new int[n][n];

        int dir = 0;
        int ib = 0;
        int ie = n-1;
        int jb = 0;
        int je = n-1;
        int val = 1;

        int i=0;
        int j=0;

        while(ib <= ie && jb <= je) {
            // lt -> rt
            if (dir == 0) {
                for (i=ib, j=jb; i <= ie; i++,val++) m[j][i] = val;
            // rt -> rb
            } else if (dir == 1) {
                for (i=ie, j=jb+1; j <= je; j++,val++) m[j][i] = val;
            // rb -> lb
            } else if (dir == 2) {
                for (i=ie-1, j=je; i>=ib; i--,val++) m[j][i] = val;
            // lb -> lt
            } else if(dir == 3) {
                for (i=ib, j=je-1; j>=jb+1; j--,val++) m[j][i] = val;
            }

            dir++;

            if (dir > 3) {
                dir = 0;
                ib++;
                jb++;
                ie--;
                je--;
            }
        }

        for (i=0; i < n; i++) {
            for (j=0; j < n; j++) {
                out.printf(String.format("% 4d", m[i][j]));
            }
            out.printf("%n");
        }
    }
}
