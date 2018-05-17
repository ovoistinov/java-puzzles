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
        int length = in.nextInt();
        int width = in.nextInt();
        int height = in.nextInt();

        int dividend = ((length + width) * 2 * height);
        int squareMetersPerCan = 16;

        out.print((dividend + squareMetersPerCan - 1) / squareMetersPerCan);
    }
}