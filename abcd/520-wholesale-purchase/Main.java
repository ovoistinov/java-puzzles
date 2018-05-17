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

        final int pairPrice = 105;
        final int packPrice = 1025;
        final int boxPrice = 11400;
        final int pairsPerBox = 144;
        final int pairsPerPack = 12;

        int boxQty = n / pairsPerBox;

        n %= pairsPerBox;

        int packQty = n / pairsPerPack;
        int pairQty = n % pairsPerPack;

        if (pairQty*pairPrice > packPrice) {
            packQty++;
            pairQty = 0;
        } 

        if (packQty*packPrice > boxPrice) {
            boxQty++;
            packQty = 0;
        } 

        if (boxPrice < (packQty*packPrice + pairQty*pairPrice)) {
            boxQty++;
            packQty = 0;
            pairQty = 0;
        }

        out.printf("%d %d %d", boxQty, packQty, pairQty);
    }
}