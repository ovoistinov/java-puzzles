import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import java.util.BitSet;

import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    private void run() throws Exception {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) throws Exception {
        int n1 = in.nextInt();
        int n2 = in.nextInt();

        BitSet bs1 = new BitSet(300_001);

        for (int i=0; i < n1; i++) {
            bs1.set(in.nextInt(), true);
        }

        BitSet bs2 = new BitSet(100_001);

        for (int i=0; i < n2; i++) {
            bs2.set(in.nextInt(), true);
        }

        bs1.and(bs2);

        int i = 0;
        while(bs1.nextSetBit(i) >= 0) {
            i = bs1.nextSetBit(i);
            out.print(i + " ");
            i++;
        }
    }
}