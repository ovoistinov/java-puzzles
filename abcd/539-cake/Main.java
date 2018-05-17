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
        int numberOfGuests = in.nextInt();

        out.print(calculateCakeCuts(numberOfGuests));
    }

    private int calculateCakeCuts(int numberOfGuests) {
        if (numberOfGuests == 1) {
            return 0;
        }

        return numberOfGuests % 2 == 0 
                ? numberOfGuests / 2 
                : numberOfGuests;
    }
}