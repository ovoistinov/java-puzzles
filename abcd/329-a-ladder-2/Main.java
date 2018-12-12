import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

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

        int[] steps = new int[n+1];

        for (int i=1; i <= n; i++) {
            steps[i] = in.nextInt();
        }

        int[] sum = new int[n+1];
        sum[0] = 0;
        sum[1] = steps[1];

        int[] path = new int[n+1];
        path[0] = 0;
        path[1] = 0;

        for (int i=2; i <=n; i++) {
            if (sum[i-1] > sum[i-2]) {
                sum[i] = sum[i-1] + steps[i];
                path[i] = i-1;
            } else {
                sum[i] = sum[i-2] + steps[i];
                path[i] = i-2;
            }
        }

        out.println(sum[n]);

        Stack<Integer> stack = new Stack<>();

        for (int i=n; i>0; i = path[i]) stack.push(i);

        while (!stack.isEmpty()) out.printf("%d ", stack.pop());
    }
}
