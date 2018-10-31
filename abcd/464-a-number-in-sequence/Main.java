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
        String seq = "011212201220200112";
        // example 1
        //
        // 0
        // 01
        // ^
        // 0112
        // ^                   n=0
        // 0112 1220
        //      ^              n=4
        // 0112 1220 1220 2001
        //                ^    n=12
        //
        // example 2
        //
        // 0112
        //  ^                  n=0
        // 0112 1220
        //       ^             n=5
        // 0112 1220 1220 2001
        //                 ^   n=13
        //
        // example 3
        //
        // 0112
        //    ^                n=3
        // 0112 1220
        //         ^           n=7
        // 0112 1220 1220 2001
        //                   ^ n=15

        int n = in.nextInt();
        out.print(calcWithBinary(n));
    }

    private int calc(int n) {
        long chunkLength = closestPowerOf2(n);
        int iterations = 0;
        int appearedInLeftHalfCount = 0;

        while(chunkLength > 1) {
            chunkLength = chunkLength / 2;
            iterations++;

            if (n > chunkLength) {
                n = n - (int) chunkLength;
                System.err.println(Integer.toBinaryString(n));
            } else {
                appearedInLeftHalfCount++;
            }
        }

        return (int) (iterations - appearedInLeftHalfCount) % 3;
    }

    // Every time we divide by 2 we remove the most significant bit
    // Therefore the task comes down to counting set bits in a number
    // module 3.
    private int calcWithBinary(int n) {
        n--;
        return Integer.bitCount(n) % 3;
    }

    private long closestPowerOf2(int n) {
        long result = Integer.highestOneBit(n);
        return n == result ? n : result << 1;
    }
}