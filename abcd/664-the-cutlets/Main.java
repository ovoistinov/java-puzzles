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
        int pan = in.nextInt();
        int time = in.nextInt();
        int n = in.nextInt();

        n = n*2;

        int turns;

        if (n <= pan) {
            turns = 2;
        } else {
            turns = (n + pan - 1) / pan;
        }

        out.print(turns * time);
    }
}