import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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

        List<Integer> result = findPalindromeRepresentations(n);

        if (result.size() == 0) {
            out.println("none");
        } else if (result.size() == 1) {
            out.println("unique");
        } else {
            out.println("multiple");
        }

        for (int i : result) {
            out.printf("%d ", i);
        }
    }

    private List<Integer> findPalindromeRepresentations(int n) {
        List<Integer> palindromeScale = new ArrayList<>();

        for (int i=2; i <= 36; i++) {
            String converted = Integer.toString(n, i);

            if (isPalindrome(converted)) {
                palindromeScale.add(i);
            }
        }

        return palindromeScale;
    }

    private boolean isPalindrome(String s) {
        return s.length() > 0 && s.contentEquals(reverse(s));
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}