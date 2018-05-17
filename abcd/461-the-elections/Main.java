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
        int n = in.nextInt();
        int[] groups = new int[n];

        for (int i=0; i < groups.length; i++) {
            groups[i] = in.nextInt();
        }

        Arrays.sort(groups);

        int count = 0;

        for (int i = 0; i < groups.length / 2 + 1; i++) {
            count += groups[i] / 2 + 1;
        }

        out.print(count);
    }
}