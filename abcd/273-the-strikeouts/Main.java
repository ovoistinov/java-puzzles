import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

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
        String s = in.next();
        char[] chars = s.toCharArray();

        boolean[] numberIsFound = new boolean[1000];

        for (int i=0; i < chars.length; i++) {
            for (int j=i+1; j < chars.length; j++) {
                for (int k=j+1; k < chars.length; k++) {
                    int number = (chars[i]-'0')*100 + (chars[j]-'0')*10 + (chars[k]-'0');

                    numberIsFound[number] = true;
                }
            }
        }

        int count = 0;
        for (int i=100; i < numberIsFound.length; i++) {
            if (numberIsFound[i]) {
                count++;
            }
        }

        out.print(count);
    }

    private void solveWithHashMap(Scanner in, PrintWriter out) {
        String s = in.next();
        char[] chars = s.toCharArray();

        Set<Integer> uniqueNumbers = new HashSet<>();

        for (int i=0; i < chars.length; i++) {
            for (int j=i+1; j < chars.length; j++) {
                for (int k=j+1; k < chars.length; k++) {
                    int number = (chars[i]-'0')*100 + (chars[j]-'0')*10 + (chars[k]-'0');

                    if (number >= 100) {
                        uniqueNumbers.add(number);
                    }
                }
            }
        }

        out.print(uniqueNumbers.size());
    }
}