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
        char[] ch = in.next().toCharArray();
        int[][] map = new int[101][101];

        int x = 50;
        int y = 50;
        map[y][x] = 1;
        int dx = 1;
        int dy = 0;
        int sCount = 0;

        for (int i=0; i < ch.length; i++) {
            char c = ch[i];

            if (c == 'S') {
                sCount++;
                x += dx;
                y += dy;

                if (map[y][x] > 0) {
                    out.print(sCount);
                    return;
                }

                map[y][x]++;
            } else if (c == 'L' && dx == 1) {
                dx = 0;
                dy = -1;
            } else if (c == 'L' && dy == -1) {
                dx = -1;
                dy = 0;
            } else if (c == 'L' && dx == -1) {
                dx = 0;
                dy = 1;
            } else if (c == 'L' && dy == 1) {
                dx = 1;
                dy = 0;
            } else if (c == 'R' && dx == 1) {
                dx = 0;
                dy = 1;
            } else if (c == 'R' && dy == -1) {
                dx = 1;
                dy = 0;
            } else if (c == 'R' && dx == -1) {
                dx = 0;
                dy = -1;
            } else if (c == 'R' && dy == 1) {
                dx = -1;
                dy = 0;
            } else {
                throw new Error();
            }
        }

        out.print(-1);
    }
}