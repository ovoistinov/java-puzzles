import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.LocalDate;
import static java.lang.Math.abs;
import java.util.Calendar;

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
        in.useDelimiter("[.]|\\s+");

        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();

        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();

        int first = getDayOfYear(m1, d1);
        int second = getDayOfYear(m2, d2);

        int diff;

        if (y1 == y2) {
            diff = second - first;
        } else {
            diff = second + (365 - first);
        }

        out.print(diff);
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

        month--;

        switch (month) {
            case Calendar.FEBRUARY: return 28;
            case Calendar.APRIL:
            case Calendar.JUNE:
            case Calendar.SEPTEMBER:
            case Calendar.NOVEMBER:
                return 30;
            default:
                return 31;
        }
    }

    private void solveWithDateUtils(Scanner in, PrintWriter out) {
        in.useDelimiter("[.]|\\s+");

        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();

        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();

        int first = LocalDate.of(y1, m1, d1).getDayOfYear();
        int second = LocalDate.of(y2, m2, d2).getDayOfYear();

        int diff;

        if (y1 == y2) {
            diff = second - first;
        } else {
            diff = 365 - first + second;
        }

        out.print(diff);
    }
}