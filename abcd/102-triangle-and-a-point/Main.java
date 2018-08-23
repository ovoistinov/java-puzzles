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
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int x3 = in.nextInt();
        int y3 = in.nextInt();

        int px = in.nextInt();
        int py = in.nextInt();

        int c1 = (x1 - px)*(y2-y1) - (x2-x1)*(y1-py);
        int c2 = (x2 - px)*(y3-y2) - (x3-x2)*(y2-py);
        int c3 = (x3 - px)*(y1-y3) - (x1-x3)*(y3-py);

        if (c1 >=0 && c2 >=0 && c3 >=0 ||
            c1 <=0 && c2 <=0 && c3 <=0) {
            out.print("In");
        } else {
            out.print("Out");
        }
    }
}