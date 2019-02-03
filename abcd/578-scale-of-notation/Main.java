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

        StringBuilder result = new StringBuilder();
        int lastDigit = 0;

        while(n >0) {
            lastDigit = n%3 == 0 ? 3 : n%3;
            n = (n - lastDigit) / 3;
            result.append(lastDigit);
        }

        out.print(result.reverse().toString());
    }
}
