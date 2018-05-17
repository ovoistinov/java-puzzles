import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;

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
        int m = in.nextInt();
        in.nextLine();

        char[][] lab = new char[n][m];

        for (int i=0; i < n; i++) {
            char[] line = in.nextLine().toCharArray();

            for (int j=0; j < m; j++) {
                lab[i][j] = line[j];
            }
        }

        boolean exitFound = false;
        Bug bug = new Bug(lab);

        long start = System.currentTimeMillis();
        while(!exitFound) {
            exitFound = bug.move();

            if (System.currentTimeMillis() - start >= 900) {
                out.print(-1);
                return;
            }
        }

        out.print(bug.moveCount);
    }

    private static class Bug {
        char[][] lab;
        int[][] move;
        int moveCount = 0;
        Direction prevDirection = Direction.DOWN;
        int x;
        int y;

        public Bug(char[][] lab) {
            this.lab = lab;
            move = new int[lab.length][lab[0].length];
            move[1][1] = 1;
            x = 1;
            y = 1;
        }

        public boolean move() {
            if (canGo(prevDirection)) {
                return move(prevDirection);
            } else if (canGo(Direction.DOWN)) {
                return move(Direction.DOWN);
            } else if (canGo(Direction.RIGHT)) {
                return move(Direction.RIGHT);
            }  else if (canGo(Direction.UP)) {
                return move(Direction.UP);
            } else if (canGo(Direction.LEFT)) {
                return move(Direction.LEFT);
            } else {
                return false;
            }
        }

        private boolean canGo(Direction d) {
            int[] m = new int[4];
            m[0] = lab[y+1][x] == '@' ? Integer.MAX_VALUE : move[y+1][x];
            m[1] = lab[y][x+1] == '@' ? Integer.MAX_VALUE : move[y][x+1];
            m[2] = lab[y-1][x] == '@' ? Integer.MAX_VALUE : move[y-1][x];
            m[3] = lab[y][x-1] == '@' ? Integer.MAX_VALUE : move[y][x-1];

            switch(d) {
                case DOWN:
                    return lab[y+1][x] != '@' && 
                        m[0] <= m[1] &&
                        m[0] <= m[2] &&
                        m[0] <= m[3];
                case RIGHT:
                    return lab[y][x+1] != '@' && 
                        m[1] <= m[0] &&
                        m[1] <= m[2] &&
                        m[1] <= m[3];
                case UP:
                    return lab[y-1][x] != '@' && 
                        m[2] <= m[0] &&
                        m[2] <= m[1] &&
                        m[2] <= m[3];
                case LEFT:
                    return lab[y][x-1] != '@' && 
                        m[3] <= m[0] &&
                        m[3] <= m[1] &&
                        m[3] <= m[2];
                default:
                    return false;
            }
        }

        private boolean move(Direction d) {
            switch(d) {
                case DOWN:
                    y++;
                    move[y][x]++;
                    prevDirection = Direction.DOWN;
                    moveCount++;
                    break;
                case RIGHT:
                    x++;
                    move[y][x]++;
                    prevDirection = Direction.RIGHT;
                    moveCount++;
                    break;
                case UP:
                    y--;
                    move[y][x]++;
                    prevDirection = Direction.UP;
                    moveCount++;
                    break;
                case LEFT:
                    x--;
                    move[y][x]++;
                    prevDirection = Direction.LEFT;
                    moveCount++;
                    break;
                default:
                    return false;
            }

            return x == lab[0].length-2 && y == lab.length-2;
        }
    }

    public enum Direction {
        DOWN,
        RIGHT,
        UP,
        LEFT
    }
}