import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solveWithBinary(in, out);
        }
    }

    // Runtime O(~c) = O(1), where c=1440
    // Memory O(1)
    // Min runtime: O(1)
    private void solveWithBinary(Scanner in, PrintWriter out) {
        in.useDelimiter(":|\\s+");

        int h = in.nextInt();
        int m = in.nextInt();

        // Direction opposite to clockwise starting from the top
        Map<Integer, Integer> numToBin = new HashMap<>();
        numToBin.put(0, Integer.parseInt("1111110", 2));
        numToBin.put(1, Integer.parseInt("0000110", 2));
        numToBin.put(2, Integer.parseInt("1011011", 2));
        numToBin.put(3, Integer.parseInt("1001111", 2));
        numToBin.put(4, Integer.parseInt("0100111", 2));
        numToBin.put(5, Integer.parseInt("1101101", 2));
        numToBin.put(6, Integer.parseInt("1111101", 2));
        numToBin.put(7, Integer.parseInt("1000110", 2));
        numToBin.put(8, Integer.parseInt("1111111", 2));
        numToBin.put(9, Integer.parseInt("1101111", 2));
        numToBin.put(10, Integer.parseInt("000000", 2));
        numToBin.put(11, Integer.parseInt("000110", 2));
        numToBin.put(12, Integer.parseInt("111011", 2));

        // For example input is 02:39
        // mask1: 00000000000101101110011111101111
        int mask1 = format(h, m, numToBin);
        // mask0: 11111111111010010001100000010000
        int mask0 = ~mask1;
        // Remove leading 1's from the zeros mask.
        // mask0: 11111111111010010001100000010000
        //        ^^^^^
        //        00000111111010010001100000010000
        mask0 ^= (Integer.parseInt("11111", 2) << 27);

        int mins = 0;

        while (mask0 + mask1 != 0) {
            mins++;
            m++;

            if (m == 60) {
                m = 0;
                h++;
            }

            if (h == 24) {
                h = 0;
                m = 0;
            }

            int cur = format(h, m, numToBin);

            mask1 &= cur;
            mask0 &= ~cur;
        }

        out.print(mins);
    }

    private int format(int h, int m, Map<Integer, Integer> numToBin) {
        int result = 0;
        // Format the hours/minutes digits
        // 
        // 00000000000101101110011111101111
        //      ^^^^^^-------+++++++=======
        //      X0:00 0X:00  00:X0  00:0X
        result |= numToBin.get(h/10 + 10) << 21;
        result |= numToBin.get(h%10) << 14;
        result |= numToBin.get(m/10) << 7;
        result |= numToBin.get(m%10);

        return result;
    }

    // Runtime O(1)
    // Memory O(1)
    // Min runtime: O(1)
    private void solveSimple(Scanner in, PrintWriter out) {
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
