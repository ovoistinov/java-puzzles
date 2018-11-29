import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
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
        int nHand = in.nextInt();
        int nBeat = in.nextInt();
        int trump = getSuit(in.next().charAt(0));

        List<TreeSet<Integer>> cards = new ArrayList<>(4);
        cards.add(new TreeSet<>()); // diamonds
        cards.add(new TreeSet<>()); // clubs
        cards.add(new TreeSet<>()); // hearts
        cards.add(new TreeSet<>()); // spades

        for (int i=0; i < nHand; i++) {
            String card = in.next();
            int rank = getRank(card.charAt(0));
            int suit = getSuit(card.charAt(1));

            cards.get(suit).add(rank);
        }

        for (int i=0; i < nBeat; i++) {
            String card = in.next();
            int rank = getRank(card.charAt(0));
            int suit = getSuit(card.charAt(1));

            boolean found = false;
            TreeSet<Integer> cur = cards.get(suit);

            if (cur.higher(rank) != null) {
                cur.remove(cur.higher(rank));
                found = true;
            }

            if (!found && suit != trump) {
                cur = cards.get(trump);

                if (cur.size() > 0) {
                    cur.remove(cur.first());
                    found = true;
                }
            }

            if (!found) {
                out.print("NO");
                return;
            }
        }

        out.print("YES");
    }

    private int getRank(char rank) {
        String ranks = "6789TJQKA";
        return ranks.indexOf(rank);
    }

    private int getSuit(char suit) {
        String suits = "DCHS";
        return suits.indexOf(suit);
    }
}
