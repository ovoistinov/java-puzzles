import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

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
        
        int maxLineSize = 12*12 + 1; // +1 since the last customer is picked up from the line at 20:00
        int noOfCustomersInFront = n - 1;

        if (noOfCustomersInFront >= maxLineSize) {
            out.print("NO");
        } else {
            int waitingTimeMinutes = noOfCustomersInFront * 5;
            out.printf("%d %d", waitingTimeMinutes / 60, waitingTimeMinutes % 60);
        }
    }
}