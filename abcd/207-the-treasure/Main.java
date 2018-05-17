import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Locale;
import static java.lang.Math.sqrt;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        Locale.setDefault(Locale.US);

        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) {
        int n = in.nextInt();

        Point destination = new Point();

        for (int i=0; i < n; i++) {
            int direction = in.nextInt();
            int nSteps = in.nextInt();

            move(direction, nSteps, destination);
        }

        out.printf("%.3f %.3f", destination.x, destination.y);
    }

    private void move(int direction, int nSteps, Point destination) {
        double diagDelta = nSteps*sqrt(2)/2;

        switch(direction) {
            case 1:
                destination.y += nSteps; 
                break;
            case 2:
                destination.x += diagDelta;
                destination.y += diagDelta;
                break;
            case 3:
                destination.x += nSteps; 
                break;
            case 4:
                destination.x += diagDelta;
                destination.y -= diagDelta;
                break;
            case 5:
                destination.y -= nSteps; 
                break;
            case 6:
                destination.x -= diagDelta;
                destination.y -= diagDelta;
                break;
            case 7:
                destination.x -= nSteps;
                break;
            case 8:
                destination.x -= diagDelta;
                destination.y += diagDelta;
                break;
            default: 
                throw new IllegalArgumentException("Wrong direction");
        }
    }

    class Point {
        double x = 0;
        double y = 0;
    }
}