import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Random;
 
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
        int m = in.nextInt();
        int len = in.nextInt();
        int v = in.nextInt();
 
        Random rand = new Random();
 
        while(true) {
            String temp = getRandomString(rand, len);
             
            if (optimizedHash(x, m, temp) == v) {
                out.print(temp);
                break;
            }
        }
    }

    private int optimizedHash(int x, int m, String s) {
        int len = s.length();
        int sum = 0;

        // Using the Horner's method for calculating polynomials:
        // a * x^3 + b * x^2 + c * x + d = ((a * x + b) * x + c) * x + d
        for (int i=len-1; i >= 0; i--) {
            sum = (sum * x + (s.charAt(i) - '0')) % m;
        }

        return sum;
    }

    private int simpleHash(int x, int m, String s) {
        int len = s.length();
        int sum = 0;
        int pow = 1;
        int i = 0;

        while(i < len) {
            int n = s.charAt(i) - '0';
 
            sum += n * pow;
            sum %= m;

            pow *= x;
            pow %= m;
 
            i++;
        }

        return sum;
    }

    private String getRandomString(Random rand, int len) {
        StringBuilder result = new StringBuilder();

        for (int i=0; i < len; i++) {
            result.append(rand.nextInt(10));
        }

        return result.toString();
    }
}