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
        String position = in.next();

        char h = position.charAt(0);
        char v = position.charAt(1);

        out.print(cellColor(h, v));
    }

    private String cellColor(char h, char v) {
        return (h + v) % 2 == 0
                ? "BLACK" 
                : "WHITE";
    }
}