import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

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

    // Runtime O(1)
    // Memory O(1)
    // Min runtime: O(1)
    private void solve(Scanner in, PrintWriter out) {
        Map<Integer, Integer> sizes = new HashMap<>();
        int[][] map = new int[12][12];

        int num = 0;

        for (int i=0; i < 6; i++) {
            int w = in.nextInt();
            int h = in.nextInt();

            if (!sizes.containsKey(w)) {
                sizes.put(w, num);
                num++;
            }

            if (!sizes.containsKey(h)) {
                sizes.put(h, num);
                num++;
            }

            int iw = sizes.get(w);
            int ih = sizes.get(h);

            map[iw][ih]++;
            if (ih != iw) map[ih][iw]++; // diagonal is placed only once
        }

        if (boxConstructionPossible(map, sizes.size())) {
            out.print("POSSIBLE");
        } else {
            out.print("IMPOSSIBLE");
        }
    }

    private boolean boxConstructionPossible(int[][] map, int sizes) {
        boolean isPossible = false;

        // square
        if (sizes == 1) {
            isPossible = true;
        // 2 square and 4 matching rectangles
        } else if (sizes == 2) {
            // check for 2 squares and 4 matching rectangles
            if (map[0][1] == 4 && (map[0][0] == 2 || map[1][1] == 2)) {
                isPossible = true;
            }
        // 3 matching rectangles
        } else if (sizes == 3) {
            // we have to check for 2 because if 3 non-matching pairs are 
            // on the diagonal then the condition will be true but the result 
            // is impossible.
            if (map[0][1] == 2 && map[0][2] == 2 && map[1][2] == 2) {
                isPossible = true;
            }
        }

        return isPossible;
    }
}
