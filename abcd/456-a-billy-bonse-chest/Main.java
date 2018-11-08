import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;

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
        int x = in.nextInt();
        int y = in.nextInt();

        // Let's do some algebraic analysis
        // 
        // y(1) = a1; // 5
        // y(2) = a2; // 2
        // y(3) = y(2) + y(1) = a2 + a1; // 7
        // y(4) = y(3) + y(2) = a2 + a1 + a2 = a1 + 2*a2; // 9
        // y(5) = y(4) + y(3) = a1 + 2*a2 + a2 + a1 = 2*a1 + 3*a2; // 2*5 + 3*2 = 16;
        // y(6) = y(5) + y(4) = (2*a1 + 3*a2) + (a1 + 2*a2) = 3*a1 + 5*a2; // 3*5 + 5*2 = 25;
        // y(7) = y(6) + y(5) = (3*a1 + 5*a2) + (2*a1 + 3*a2) = 5*a1 + 8*a2; // 5*5 + 8*2 = 41;
        //
        // y(x) = fib(x-2)*a1 + fib(x-1)*a2;
        // a1 = (y(x) - fib(x-1)*a2) / fib(x-2);
        // 
        // If x=6 then fib(x-1) = 5 and fib(x-2) = 3

        int fib[] = new int[x-1];
        fib[0] = 1;
        fib[1] = 1;

        for (int i=2; i < fib.length; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        for (int a2 = 0; a2 <= 32767; a2++) {
            int dividend = y - fib[x-2]*a2;
            int divisor = fib[x-3];

            if (dividend > 0 && dividend % divisor == 0) {
                out.printf("%d %d", dividend / divisor, a2);
            }

        }
    }
}
