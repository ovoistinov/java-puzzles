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
        char[] start = in.next().toCharArray();
        char[] end = in.next().toCharArray();

        if (isKnightMove(start[0], start[1], end[0], end[1])) {
            out.print(1);
            return;
        }

        for (char h='a'; h <= 'h'; h++) {
            for (char v='1'; v <= '8'; v++) {
                if (isKnightMove(start[0], start[1], h, v) && 
                    isKnightMove(h, v, end[0], end[1])) {
                    out.print(2);
                    return;
                }
            }
        }

        out.print("NO");
    }

    private boolean isKnightMove(char h1, char v1, char h2, char v2) {
        int h = h1 - h2;
        int v = v1 - v2;
        return h*h + v*v == 5;
    }
}