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
        int sizeJ = in.nextInt();
        int sizeI = in.nextInt();

        char[][] firstImg = new char[sizeI][];
        for (int i=0; i < sizeI; i++) {
            firstImg[i] = in.next().toCharArray();
        }

        char[][] secondImg = new char[sizeI][];
        for (int i=0; i < sizeI; i++) {
            secondImg[i] = in.next().toCharArray();
        }

        String s = in.next();
        char[][] operation = new char[2][2];
        operation[0][0] = s.charAt(0);
        operation[0][1] = s.charAt(1);
        operation[1][0] = s.charAt(2);
        operation[1][1] = s.charAt(3);

        for (int i=0; i < sizeI; i++) {
            for (int j=0; j < sizeJ; j++) {
                int firstPixel = firstImg[i][j] - '0';
                int secondPixel = secondImg[i][j] - '0';

                out.print(operation[firstPixel][secondPixel]);
            }

            out.println();
        }
    }
}