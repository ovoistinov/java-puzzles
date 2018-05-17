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
        int nChildren = in.nextInt();
        int nAdults = in.nextInt();
        int peoplePerBus = in.nextInt();

        if (peoplePerBus <= 2) {
            out.print(0);
            return;
        }

        int maxAdultBuses = nAdults / 2;
        int minChildrenBuses = (nChildren + (peoplePerBus - 2) - 1) / (peoplePerBus - 2);

        if (maxAdultBuses < minChildrenBuses) {
            out.print(0);
            return;
        }

        int nb = ((nChildren + nAdults) + peoplePerBus - 1) / peoplePerBus;

        out.print(nb);
    }
}