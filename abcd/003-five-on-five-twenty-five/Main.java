import java.util.*;
import java.io.*;

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
        long inputNumber = in.nextLong();

        if (inputNumber % 5 != 0) {
            throw new IllegalArgumentException("Input is invalid.");
        }

        out.print(inputNumber * inputNumber);
    }
}