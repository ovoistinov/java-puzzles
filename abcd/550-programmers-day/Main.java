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
        int year = in.nextInt();

        String dayAndMonth = isLeap(year) ? "12/09/" : "13/09/";

        out.print(dayAndMonth + String.format("%04d", year));
    }

    private boolean isLeap(int year) {
    	return (year % 4 == 0 && year % 100 != 0)
    	        || year % 400 == 0;
    }
}