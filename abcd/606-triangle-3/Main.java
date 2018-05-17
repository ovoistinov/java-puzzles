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
        int v1 = in.nextInt();
        int v2 = in.nextInt();
        int v3 = in.nextInt();

        out.print(isNonDegenerate(v1, v2, v3));
    }

    private String isNonDegenerate(int v1, int v2, int v3) {
        return v1 + v2 > v3 && v2 + v3 > v1 && v1 + v3 > v2 
            ? "YES"
            : "NO";
    }
}