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
            solveWithFormula(in, out);
        }
    }

    private void solveWithFormula(Scanner in, PrintWriter out) {
        int swordHeadCut = in.nextInt();
        int initialHeads = in.nextInt();
        int regenHeads = in.nextInt();

        if (swordHeadCut >= initialHeads) {
            out.print(1);
            return;
        }

        if (swordHeadCut <= regenHeads) {
            out.print("NO");
            return;
        }

        // (initialHeads-swordHeadCut)/(swordHeadCut-regenHeads) plus the first hit with 
        // the division rounded up: a/^b = (a+b-1)/b. Then 
        // (initialHeads-swordHeadCut+swordHeadCut-regenHeads-1)/(swordHeadCut-regenHeads)= 
        // =(initialHeads-regenHeads-1)/(swordHeadCut-regenHeads), which is with the first 
        // hit is 1 + (initialHeads-regenHeads-1)/(swordHeadCut-regenHeads). Another 
        // formula: a/^b=(a-1)/b+1. Then with the first hit it will be 
        // 2 + (initialHeads-swordHeadCut-1)/(swordHeadCut-regenHeads).
        int hits = 1 + (initialHeads - regenHeads - 1) / (swordHeadCut - regenHeads);

        out.print(hits);
    }

    private void solve(Scanner in, PrintWriter out) {
        int swordHeadCut = in.nextInt();
        int initialHeads = in.nextInt();
        int regenHeads = in.nextInt();

        if (swordHeadCut >= initialHeads) {
            out.print(1);
            return;
        } 

        if (swordHeadCut <= regenHeads) {
            out.print("NO");
            return;
        }

        int count = 0;
        int result = initialHeads;

        do {
            result = result - swordHeadCut + regenHeads;
            count++;
        } while(result - regenHeads > 0);

        out.print(count);
    }
}