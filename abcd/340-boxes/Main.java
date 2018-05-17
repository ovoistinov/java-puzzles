import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.Math.max;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solveWithoutArrays(in, out);
        }
    }

    private void solveWithArrays(Scanner in, PrintWriter out) {
        int[] b1 = new int[3];
        int[] b2 = new int[3];

        b1[0] = in.nextInt();
        b1[1] = in.nextInt();
        b1[2] = in.nextInt();

        b2[0] = in.nextInt();
        b2[1] = in.nextInt();
        b2[2] = in.nextInt();

        Arrays.sort(b1);
        Arrays.sort(b2);

        if (Arrays.equals(b1, b2)) {
            out.print("Boxes are equal");
        } else if (b1[0] >= b2[0] && b1[1] >= b2[1] && b1[2] >= b2[2]) {
            out.print("The first box is larger than the second one");
        } else if (b2[0] >= b1[0] && b2[1] >= b1[1] && b2[2] >= b1[2]) {
            out.print("The first box is smaller than the second one");
        } else {
            out.print("Boxes are incomparable");
        }
    }

    private void solveWithoutArrays(Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        int a1 = Math.min(a, Math.min(b, c));
        int c1 = Math.max(a, Math.max(b, c));
        int b1 = a + b + c - a1 - c1;

        a = in.nextInt();
        b = in.nextInt();
        c = in.nextInt();
        
        int a2 = Math.min(a, Math.min(b, c));
        int c2 = Math.max(a, Math.max(b, c));
        int b2 = a + b + c - a2 - c2;

        if (a1 == a2 && b1 == b2 && c1 == c2) {
            out.print("Boxes are equal");
        } else if (a1 >= a2 && b1 >= b2 && c1 >= c2) {
            out.print("The first box is larger than the second one");
        } else if (a2 >= a1 && b2 >= b1 && c2 >= c1) {
            out.print("The first box is smaller than the second one");
        } else {
            out.print("Boxes are incomparable");
        }
    }
}