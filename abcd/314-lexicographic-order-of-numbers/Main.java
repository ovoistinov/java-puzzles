import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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
        int k = in.nextInt();

        List<String> num = new ArrayList<>();

        for (int i=0; i < n; i++) {
            num.add("" + (i+1));
        }

        Collections.sort(num);

        for (int i=0; i < n; i++) {
            if (k == Integer.valueOf(num.get(i)).intValue()) {
                out.print(i+1);
                return;
            }
        }

    }
}