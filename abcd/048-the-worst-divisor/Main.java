import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

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
        String n = in.next();

        out.print("1" + String.join("", Collections.nCopies(countZeros(n), "0")));
    }

    private int countZeros(String n) {
        int count = 0;

        while(n.charAt(n.length() - 1 - count) == '0') {
            count++;
        }

        return count;
    }
}