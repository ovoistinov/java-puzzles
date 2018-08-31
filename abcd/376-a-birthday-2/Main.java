import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        try (
            Scanner in = new Scanner(new File("input.txt"));
            PrintWriter out = new PrintWriter(new File("output.txt"));
        ) {
            solveManualRoll(in, out);
        }
    }

    private void solveManualRoll(Scanner in, PrintWriter out) {
        int bDay = in.nextInt();
        int bMonth = in.nextInt();

        int day = in.nextInt();
        int month = in.nextInt();
        int year = in.nextInt();

        int count = 0;
        while(!(day == bDay && month == bMonth)) {
            int maxDaysInMonth;

            if (month == 2) {
                maxDaysInMonth = isLeap(year) ? 29 : 28;
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                maxDaysInMonth = 30;
            } else {
                maxDaysInMonth = 31;
            }

            if (month == 12 && day == 31) { // end of year
                year++;
                month = 1;
                day = 1;
            } else if (day == maxDaysInMonth) {
                month++;
                day = 1;
            } else {
                day++;
            }

            count++;
        }

        out.print(count);
    }

    private boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private void solveLocalDateTime(Scanner in, PrintWriter out) {
        int bDay = in.nextInt();
        int bMonth = in.nextInt();

        int day = in.nextInt();
        int month = in.nextInt();
        int year = in.nextInt();

        LocalDate date = LocalDate.of(year, month, day);
        LocalDate bDate = LocalDate.of(1904, bMonth, bDay);

        int count = 0;

        while(bDate.getMonth() != date.getMonth() || bDate.getDayOfMonth() != date.getDayOfMonth()) {
            date = date.plus(1, ChronoUnit.DAYS);
            count++;
        }

        out.print(count);
    }
}