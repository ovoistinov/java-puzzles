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

    // Runtime O(1)
    // Memory O(1)
    // Min runtime: O(1)
    private void solve(Scanner in, PrintWriter out) {
        in.useDelimiter(":|\\s+");

        int h = in.nextInt();
        int m = in.nextInt();

        //  0:00 -  9:59 - min time to check all is 20:00 (hours 2 digit must be/pass 5,
        //                                                 hours 1 digit must pass 1 and 2)
        // 10:00 - 16:59 - min time to check all is  0:00 (hours 1 digit must pass 2 and _)
        // 17:00 - 19:59 - min time to check all is  5:00 (hours 1 digit must pass 2 and _,
        //                                                 hours 2 digit must be/pass 5 to reset)
        // 20:00 - 23:59 - min time to check all is 10:00
        int mins;
        if (h < 10) { 
            mins = 20*60 - (h*60 + m);
        } else if (h < 17) {
            mins = 24*60 - (h*60 + m);
        } else if (h < 20) {
            mins = (24 + 5)*60 - (h*60 + m);
        } else {
            mins = (24 + 10)*60 - (h*60 + m);
        }

        out.print(mins);
    }
}
