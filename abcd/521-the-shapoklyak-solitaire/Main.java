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
        int p = in.nextInt();
        int k = in.nextInt();

        countCardTakes(2, 999);

        out.print(countCardTakes(p, k));
    }

    private int countCardTakes(int firstDeckSize, int lastDeskSize) {
        int cardTakes = 0;

        for (int deckSize = firstDeckSize; deckSize <= lastDeskSize; deckSize++) {
            cardTakes += countDeckCardTakes(deckSize);
        }

        return cardTakes;
    }

    private int countDeckCardTakes(int deckSize) {
        int cardTakes = 0;

        while (deckSize > 2) {
            if (deckSize % 2 == 0) {
                deckSize = deckSize / 2;
            } else {
                if (deckSize <= (Integer.MAX_VALUE - 1)/3) {
                    deckSize = deckSize*3 + 1;
                } else {
                    throw new AssertionError("The solitaire does not converge.");
                }
            }

            cardTakes++;
        }

        return cardTakes;
    }
}