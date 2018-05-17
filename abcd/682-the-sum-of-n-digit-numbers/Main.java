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

        out.print(getSum(n));
    }

    private String getSum(int n) {
        // n=1: 45
        // n=2: 4905
        // n=3: 494550
        // n=4: 49495500
        // n=5: 4949955000
        // n=6: 494999550000
        // n=7: 49499995500000
        // n=8: 4949999955000000
        //
        // If n>3 then the number is "494" + "9"*(n-3 times) + "55" + "0"*(n-2 times)

        if (n == 1) {
            return "45";
        } else if (n == 2) {
            return "4905";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("494");

        for (int i=0; i < n-3; i++) {
            sb.append("9");
        }

        sb.append("55");

        for (int i=0; i < n-2; i++) {
            sb.append("0");
        }

        return sb.toString();
    }
}