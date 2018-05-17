import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
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

        int days = getDayOfYear(m2, d2, y2);

        for (int y = y1; y <= y2-1; y++) {
            days += isLeap(y) ? 366 : 365;
        }

        days -= (getDayOfYear(m1, d1, y1) - 1); // current day should be included

        out.print(days);
    }

    private boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private int getDayOfYear(int month, int day, int year) {
        int days = 0;

        for (int m=1; m < month; m++) {
            days += getDaysInMonth(m, year);
        }

        days += day;

        return days;
    }

    private int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Wrong month");
        }

        month--;

        switch (month) {
            case Calendar.FEBRUARY: return isLeap(year) ? 29 : 28;
            case Calendar.APRIL:
            case Calendar.JUNE:
            case Calendar.SEPTEMBER:
            case Calendar.NOVEMBER:
                return 30;
            default:
                return 31;
        }
    }
}