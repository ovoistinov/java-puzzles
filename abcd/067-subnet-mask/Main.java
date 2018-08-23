import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Integer.valueOf;

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
        int[] subnet = new int[in.nextInt()];

        for (int i=0; i < subnet.length; i++) {
            subnet[i] = ipStringToInt(in.next());
        }

        int pairCount = in.nextInt();

        for (int i=0; i < pairCount; i++) {
            int ip1 = ipStringToInt(in.next());
            int ip2 = ipStringToInt(in.next());
            int count = 0;

            for (int j=0; j < subnet.length; j++) {
                if ((subnet[j] & ip1) == (subnet[j] & ip2)) {
                    count++;
                }
            }

            out.println(count);
        }
    }

    private int ipStringToInt(String s) {
        String[] part = s.split("\\.");

        int result = 0;

        result |= Integer.valueOf(part[0]);
        result <<= 8;
        result |= Integer.valueOf(part[1]);
        result <<= 8;
        result |= Integer.valueOf(part[2]);
        result <<= 8;
        result |= Integer.valueOf(part[3]);

        return result;
    }
}