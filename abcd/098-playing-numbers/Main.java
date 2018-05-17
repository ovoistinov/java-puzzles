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
        int n = in.nextInt();
        int[] numbers = new int[n];

        for (int i=0; i < n; i++) {
            numbers[i] = in.nextInt();
        }

        int left = 0;
        int right = numbers.length - 1;

        int[] playerScore = new int[2];
        int count = 0;

        while (right - left != -1) {
            if (numbers[right] > numbers[left]) {
                playerScore[count % 2] += numbers[right];
                right--;
            } else {
                playerScore[count % 2] += numbers[left];
                left++;
            }

            count++;
        }

        out.printf("%d:%d", playerScore[0], playerScore[1]);
    }
}