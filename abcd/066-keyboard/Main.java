import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
            solveWithString(in, out);
        }
    }

    private void solveWithString(Scanner in, PrintWriter out) {
        String keyboard = "qwertyuiopasdfghjklzxcvbnmq";
        String singleLetter = in.next();

        out.print(keyboard.charAt(keyboard.indexOf(singleLetter) + 1));
    }

    private void solveWithHashMap(Scanner in, PrintWriter out) {
        String letterString = in.next();
        char[] keyboard = "qwertyuiopasdfghjklzxcvbnm".toCharArray();

        HashMap<Character, Character> keyMap = new HashMap<>();

        for (int i=0; i < keyboard.length; i++) {
            if (i == keyboard.length - 1) {
                keyMap.put(keyboard[i], keyboard[0]);
            } else {
                keyMap.put(keyboard[i], keyboard[i + 1]);
            }
        }

        out.print(keyMap.get(letterString.charAt(0)));
    }
}