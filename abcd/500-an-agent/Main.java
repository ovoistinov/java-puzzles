import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;

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

        Agent[] agents = new Agent[n];

        for (int i=0; i < n; i++) {
            agents[i] = new Agent(in.nextInt(), in.nextInt());
        }

        Arrays.sort(agents, Comparator.comparing(Agent::getAge));

        int[] minRisk = new int[n];

        minRisk[1] = agents[1].risk;
        if (n > 2) minRisk[2] = agents[1].risk + agents[2].risk;
        if (n > 3) minRisk[3] = agents[1].risk + agents[3].risk;

        for (int i=4; i < n; i++) {
            // Risk is minimal for group size 2 or 3
            minRisk[i] = Math.min(
                // last group size 2
                // group 1      group 2
                // *  -  *      *  -  *
                // i-3   i-2    i-1   i
                //       ^            ^
                minRisk[i-2] + agents[i].risk,
                // last group size 3
                // group 1      group 2
                // *  -  *      *  -  *  -  *
                // i-4   i-3    i-2   i-1   i
                //       ^            ^     ^
                minRisk[i-3] + agents[i-1].risk + agents[i].risk
            );
        }

        out.print(minRisk[n-1]);
    }

    private class Agent {
        int age;
        int risk;

        public Agent(int age, int risk) {
            this.age = age;
            this.risk = risk;
        }

        public int getAge() { return age; }
    }
}