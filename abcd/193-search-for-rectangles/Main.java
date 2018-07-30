import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.Math;

import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.DataInputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    private void run() throws Exception {
        Reader in = new Reader("input.txt");
        PrintWriter out = new PrintWriter(new File("output.txt"));

        solve(in, out);

        out.close();
    }

    private void solve(Reader in, PrintWriter out) throws Exception {
        int iSize = in.nextInt();
        int jSize = in.nextInt();
        int nRectangles = in.nextInt();

        final int X_LEFT = 0;
        final int Y_BOTTOM = 1;
        final int X_RIGHT = 2;
        final int Y_TOP = 3;

        short[][] rect = new short[nRectangles + 1][4];

        for (int i=0; i < rect.length; i++) {
            rect[i][X_LEFT] = 200;
            rect[i][Y_BOTTOM] = 200;
        }

        boolean[] used = new boolean[nRectangles + 1];

        int count = 0;
        int index = 0;

        for (int i=0; i < iSize; i++) {
            for (int j=0; j < jSize; j++) {
                int n = in.nextInt();

                if (n == 0) continue;

                rect[n][X_LEFT] = (short) Math.min(rect[n][X_LEFT], j);
                rect[n][X_RIGHT] = (short) Math.max(rect[n][X_RIGHT], j + 1);
                rect[n][Y_TOP] = (short) Math.max(rect[n][Y_TOP], iSize - i);
                rect[n][Y_BOTTOM] = (short) Math.min(rect[n][Y_BOTTOM], iSize - 1 - i);

                if (!used[n]) {
                    used[n] = true;
                }

                count++;
                index = n;
            }
        }

        // Edge case, example:
        // 1 1 5
        // 3
        if (count == 1) {
            for (int i=0; i < used.length; i++) {
                rect[i][X_LEFT] = rect[index][X_LEFT];
                rect[i][X_RIGHT] = rect[index][X_RIGHT];
                rect[i][Y_TOP] = rect[index][Y_TOP];
                rect[i][Y_BOTTOM] = rect[index][Y_BOTTOM];
            }
        }

        for (int i=1; i < nRectangles + 1; i++) {
            out.print(rect[i][X_LEFT]);
            out.print(' ');
            out.print(rect[i][Y_BOTTOM]);
            out.print(' ');
            out.print(rect[i][X_RIGHT]);
            out.print(' ');
            out.print(rect[i][Y_TOP]);
            out.println();
        }
    }

    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}