import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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
        in.nextLine();

        int[] timeMoments = new int[n];

        for (int i=0; i < timeMoments.length; i++) {
            String s = in.nextLine();

            int month = Integer.parseInt(s.substring(3, 5));
            int day = Integer.parseInt(s.substring(0, 2));
            int hours = Integer.parseInt(s.substring(7, 9));
            int minutes = Integer.parseInt(s.substring(10, 12));

            int daysOfYearBefore = getDayOfYear(month, day) - 1; // We don't count current day
            hours -= 10; // The working day starts at 10:00

            timeMoments[i] = daysOfYearBefore * 8 * 60 + hours * 60 + minutes;
        }

        Arrays.sort(timeMoments);

        int workMinutes = 0;

        for (int i=0; i < timeMoments.length; i+=2) {
            workMinutes += timeMoments[i+1] - timeMoments[i] + 1;
        }

        out.printf("%d:%02d", workMinutes / 60, workMinutes % 60);
    }

    private int getDayOfYear(int month, int day) {
        int days = 0;

        for (int m=1; m < month; m++) {
            days += getDaysInMonth(m);
        }

        days += day;

        return days;
    }

    private int getDaysInMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Wrong month");
        }

        if (month == 2) {
            return 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }
}