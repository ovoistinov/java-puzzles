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

    // Runtime O(1)
    // Memory O(1)
    // Min runtime: iterative approach is too slow for n=2^30 (needs ~billion ops)
    private void solve(Scanner in, PrintWriter out) {
        long n = in.nextInt();

        // Initial number n=14L, which is in short form:
        // 1110
        //
        // 1. Find the rightmost bit by n & -n (AND), which is:
        //    n: 0000000000000000000000000000000000000000000000000000000000001110
        //   -n: 1111111111111111111111111111111111111111111111111111111111110010
        // n&-n: 0000000000000000000000000000000000000000000000000000000000000010
        // 
        // 2. Find the leftmost bit by n + rightmost bit:
        //   n:  0000000000000000000000000000000000000000000000000000000000001110
        // rmb:  0000000000000000000000000000000000000000000000000000000000000010
        // res:  0000000000000000000000000000000000000000000000000000000000010000
        //
        // 3. Combine all the right ones except the leading bit (XOR):
        //   n:  0000000000000000000000000000000000000000000000000000000000001110
        // lmb:  0000000000000000000000000000000000000000000000000000000000010000
        // res:  0000000000000000000000000000000000000000000000000000000000011110
        //
        // 4. Shift ones right by 1 (extra left 1 added) and by rightmost bit 
        // times. In this case it will be 1+2=3 times:
        // res:  0000000000000000000000000000000000000000000000000000000000000011
        // 
        // 5. Combine all the ones together (OR):
        // lmb:  0000000000000000000000000000000000000000000000000000000000010000
        // ons:  0000000000000000000000000000000000000000000000000000000000000011
        // res:  0000000000000000000000000000000000000000000000000000000000010011
        //
        // The answer is 19.

        long rightmostBit = n & -n;
        long leftmostBit = n + rightmostBit;
        long ones = n ^ leftmostBit;
        ones = (ones >> 2)/rightmostBit;

        long result = leftmostBit | ones;

        out.print(result);
    }
}
