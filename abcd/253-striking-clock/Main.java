import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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
        int ticksFrom = in.nextInt() * 60 + in.nextInt();
        int ticksTo = in.nextInt() * 60 + in.nextInt();

        if (ticksFrom > ticksTo) {
            ticksTo = 24 * 60 + ticksTo;
        }

        int strikes = 0;

        for (int t = ticksFrom; t <= ticksTo; t++) {
            strikes += getStrikeCountIfAny(t);
        }

        out.print(strikes);
    }

    private int getStrikeCountIfAny(int tick) {
        int clockTime = tick % (12 * 60);

        if (clockTime % 60 == 0) {
            return clockTime == 0 ? 
                    12 : 
                    clockTime / 60;
        } else if (clockTime % 30 == 0) {
            return 1;
        } else {
            return 0;
        }
    }
}