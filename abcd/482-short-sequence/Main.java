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

        StringBuilder sequence = new StringBuilder();

        for (int i=0; sequence.length() < 32768; i++) {
            for (int j=1; j < i; j++) {
                sequence.append(j);
            }
        }

        out.print(sequence.charAt(n - 1));
    }
}