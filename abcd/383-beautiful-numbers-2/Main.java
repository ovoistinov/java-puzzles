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

        int found = 0;
        int number = 1;

        while(true) {
            int digits = 0;
            int sum = 0;
            int tempNumber = number;

            while (tempNumber > 0) {
                sum += tempNumber%10;
                tempNumber /= 10;
                digits++;
            }

            if (sum % digits == 0) {
                found++;
            }

            if (found == n) {
                break;
            }

            number++;
        }

        out.print(number);
    }
}