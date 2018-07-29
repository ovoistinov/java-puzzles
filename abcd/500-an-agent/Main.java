import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

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

        List<Agent> agents = new ArrayList<>();

        for (int i=0; i < n; i++) {
        	agents.add(new Agent(in.nextInt(), in.nextInt()));
        }

        agents.sort(Comparator.comparing(a -> a.risk));

    }

    private class Agent {
    	int age;
    	int risk;

    	public Agent(int age, int risk) {
    		this.age = age;
    		this.risk = risk;
    	}
    }
}