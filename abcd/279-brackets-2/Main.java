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

    // Runtime O(S.length)
    // Memory O(S.length)
    // Min runtime: O(S.length)
    private void solve(Scanner in, PrintWriter out) {
        char[] brackets = in.next().toCharArray();

        Stack<Character> temp = new Stack<>();

        int count = 0;
        for (int i=0; i < brackets.length; i++) {
            char b = brackets[i];

            if (b == '[' || b == '(') {
                temp.push(b);
            } else {
                if (temp.size() == 0) {
                    out.print(-1);
                    return;
                }

                char t = temp.pop();

                if (b == ']' && t != '[') count++;
                if (b == ')' && t != '(') count++;
            }
        }

        if (temp.size() > 0) {
            out.print(-1);
        } else {
            out.print(count);
        }
    }
}
