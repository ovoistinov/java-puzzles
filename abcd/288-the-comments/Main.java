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
        in.useDelimiter("\uFFFF");
        String content = in.next();

        Tag openTag = null;
        int count = 0;
        int i=0;

        while(i < content.length()) {
            char cCur = content.charAt(i);
            char cNext = '\n';

            if (i + 1 < content.length()) {
                cNext = content.charAt(i + 1);
            }

            if (openTag == null) {
                if (Tag.CurlyBracket.isOpening(cCur, cNext)) {
                    openTag = Tag.CurlyBracket;
                } else if (Tag.SymbolicString.isOpening(cCur, cNext)) {
                    openTag = Tag.SymbolicString;
                } else if (Tag.BracketStar.isOpening(cCur, cNext)) {
                    openTag = Tag.BracketStar;
                } else if (Tag.LineComment.isOpening(cCur, cNext)) {
                    openTag = Tag.LineComment;
                } else {
                    i++;
                    continue;
                }

                i += openTag.openingSegment.length();
            } else {
                if (openTag.isClosing(cCur, cNext)) {
                    if (openTag != Tag.SymbolicString) {
                        count++;
                    }

                    i += openTag.closingSegment.length();
                    openTag = null;
                } else {
                    i++;
                }
            }
        }

        if (Tag.LineComment == openTag) {
            count++;
        }

        out.print(count);
    }

    private enum Tag {
        CurlyBracket("{", "}"),
        SymbolicString("'", "'"),
        BracketStar("(*", "*)"),
        LineComment("//", System.getProperty("line.separator"));

        String openingSegment;
        String closingSegment;

        private Tag(String openingSegment, String closingSegment) {
            this.openingSegment = openingSegment;
            this.closingSegment = closingSegment;
        }

        boolean isOpening(char first, char second) {
            return openingSegment.length() > 1 ?
                openingSegment.equals("" + first + second) :
                openingSegment.equals("" + first);
        }

        boolean isClosing(char first, char second) {
            return closingSegment.length() > 1 ?
                closingSegment.equals("" + first + second) :
                closingSegment.equals("" + first);
        }
    }
}