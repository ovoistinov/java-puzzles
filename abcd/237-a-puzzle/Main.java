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
        int rebusWordCount = in.nextInt();
        int wordCount = in.nextInt();

        byte[] letters = new byte[26];

        for (int i=0; i < rebusWordCount; i++) {
            countWordLetters(letters, in.next(), 1);
        }

        for (int i=0; i < wordCount; i++) {
            countWordLetters(letters, in.next(), -1);
        }

        for (int i=0; i < letters.length; i++) {
            for (int j=0; j < letters[i]; j++) {
                out.printf("%c", 'A' + i);
            }
        }
    }

    private void countWordLetters(byte[] letters, String word, int increment) {
        for (int i=0; i < word.length(); i++) {
            letters[word.charAt(i) - 'A'] += increment;
        }
    }
}