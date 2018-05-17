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
        int rOuter = in.nextInt();
        int rInner = in.nextInt();
        int h = in.nextInt();
        int b = in.nextInt();

        //
        //    |\
        //    |  \
        // a1 |    \ c
        //    |      \
        //    ----------
        //       a2
        //
        // a1 = (h - b + rInner), - in the "worst case" (when c = rOuter) 
        // is a center of the outer circle.
        // a2 = rInner, - half of the tree diameter.
        // c is calculated according to the Pythagoras theorem.
        // c*c is less or equal to rOuter*rOuter for "YES", otherwise "NO" .

        int a1 = (h-b+rInner);
        int a2 = rInner;
        int cSquare = a1*a1 + a2*a2;

        if (a1 < 0 || cSquare <= rOuter*rOuter) {
            out.print("YES");
        } else {
            out.print("NO");
        }
    }
}