import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

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
        
        int[] lim = new int[n];
        
        for (int i=0; i < n; i++) {
            lim[i] = in.nextInt();
        }

        int nPress = in.nextInt();

        for (int i=0; i < nPress; i++) {
            int press = in.nextInt() - 1;
            lim[press]--;
        }

        for (int k : lim) {
            out.println(k >=0 ? "no" : "yes");
        }
    }
}