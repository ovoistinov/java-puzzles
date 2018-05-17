import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

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
        Set<String> friends = new TreeSet<>();
        Set<String> mutualFriends = new TreeSet<>();
        Set<String> alsoFriendOf = new TreeSet<>();

        int nFriends = in.nextInt();
        for (int i=0; i < nFriends; i++) {
            friends.add(in.next());
        }

        int nMutualFriends = in.nextInt();
        for (int i=0; i < nMutualFriends; i++) {
            String person = in.next();
            
            if (friends.contains(person)) {
                mutualFriends.add(person);
            } else {
                alsoFriendOf.add(person);
            }
        }

        out.printf("Friends: %s%n", printSet(friends));
        out.printf("Mutual Friends: %s%n", printSet(mutualFriends));
        out.printf("Also Friend of: %s%n", printSet(alsoFriendOf));
    }

    private String printSet(Set<String> set) {
        return set.stream().
            collect(Collectors.joining(", ")).toString();
    }

}