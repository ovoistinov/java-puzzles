import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import static java.lang.Integer.valueOf;

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
        in.useDelimiter(":|\\s+");

        int startTime = 
                valueOf(in.nextInt())*60*60 + 
                valueOf(in.nextInt())*60 + 
                valueOf(in.nextInt());
        int endTime = 
                valueOf(in.nextInt())*60*60 + 
                valueOf(in.nextInt())*60 + 
                valueOf(in.nextInt());

        int[] num = new int[10];

        for (int i=startTime; i <= endTime; i++) {
            int hours = i / (60*60);
            int minutes = i / 60 % 60;
            int seconds = i % 60;

            num[hours/10]++;
            num[hours%10]++;
            num[minutes/10]++;
            num[minutes%10]++;
            num[seconds/10]++;
            num[seconds%10]++;
        }

        for (int i=0; i < 10; i++) {
            out.println(num[i]);
        }
    }
}