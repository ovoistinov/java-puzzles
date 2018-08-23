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
        int days = in.nextInt();

        int year = 2008;
        int month = 1;
        int monthDay = 1;
        int weekDay = 2;

        for (int d=0; d < days; d++) {
            int daysInCurrentMonth = getDaysInMonth(month, year);

            if (month == 12 && monthDay == 31) {
                year++;
                month = 1;
                monthDay = 1;
            } else if (monthDay == daysInCurrentMonth) {
                month++;
                monthDay = 1;
            } else {
                monthDay++;
            }

            if (weekDay < 7) {
                weekDay++;
            } else {
                weekDay = 1;
            }
        }

        out.printf("%s, %02d.%02d", 
            getWeekDayNames()[weekDay-1], 
            monthDay, 
            month
        );
    }

    private boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private int getDaysInMonth(int month, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Wrong month");
        }

        if (month == 2) {
            return isLeap(year) ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    private String[] getWeekDayNames() {
        return new String[] {
            "Monday", 
            "Tuesday", 
            "Wednesday", 
            "Thursday", 
            "Friday", 
            "Saturday", 
            "Sunday"
        };
    }
}