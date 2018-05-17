import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Math.sin;
import static java.lang.Math.cos;

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
        int sideLength = in.nextInt();

        // 1. outer circle
        // Having one side we can build a isosceles triangle, which can be split on 2 right triangles.
        // A single right triangle is enough to calculate the outer and inner circle radiuses.
        //
        //              |\
        //              |  \
        // sideLength/2 |    \ outer
        //              | angle \
        //              ----------
        //                inner
        //
        // 1. angle = (360'/n) / 2 = 180'/n. In radians 180' = PI, so angle = PI/n.
        // 2. outer = (sideLength/2)/sin(angle) = (sideLength/2)/sin(PI/n)
        // 3. inner = outer * cos(angle) = outer*cos(PI/n)

        double angle = Math.PI/n;
        double outer = (sideLength/2.0)/sin(angle);
        double inner = outer*cos(angle);

        String result = outer - inner < 1.0 ?
                "YES" :
                "NO";

        out.print(result);
    }
}