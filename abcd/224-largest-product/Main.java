import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

import java.io.StreamTokenizer;
import java.io.FileReader;
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

        solveWithArrays(in, out);

        out.flush();
        out.close();
    }

    // Runtime: O(n)
    // Memory: O(1)
    private void solveWithArrays(Reader in, PrintWriter out) throws Exception {
        int n = in.nextInt();

        long[] max = new long[3];
        max[0] = max[1] = max[2] = Integer.MIN_VALUE;

        long[] min = new long[2];
        min[0] = min[1] = Integer.MAX_VALUE;

        for (int i=0; i < n; i++) {
            long num = in.nextInt();

            // work on max
            if (num >= max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = num;
            } else if (num >= max[1]) {
                max[2] = max[1];
                max[1] = num;
            } else if (num >= max[2]) {
                max[2] = num;
            }

            // work on min
            if (num <= min[0]) {
                min[1] = min[0];
                min[0] = num;
            } else if (num <= min[1]) {
                min[1] = num;
            }
        }

        out.print(Math.max(max[0]*max[1]*max[2], min[0]*min[1]*max[0]));
    }

    // Runtime: O(n)
    // Memory: O(1)
    private void solveWithPriorityQueue(Reader in, PrintWriter out) throws Exception {
        int n = in.nextInt();

        PriorityQueue<Integer> maxQ = new PriorityQueue<>();
        PriorityQueue<Integer> minQ = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=0; i < n; i++) {
            int num = in.nextInt();

            maxQ.add(num);

            if (maxQ.size() > 3) maxQ.poll();

            minQ.add(num);

            if (minQ.size() > 2) minQ.poll(); 
        }

        long max3 = maxQ.poll();
        long max2 = maxQ.poll();
        long max1 = maxQ.poll();

        long min2 = minQ.poll();
        long min1 = minQ.poll();

        out.print(Math.max(max1*max2*max3, min1*min2*max1));
    }

    // Runtime: O(N*log(n))
    // Memory: O(n)
    private void solveWithSorting(Reader in, PrintWriter out) throws Exception {
        int n = in.nextInt();

        long[] num = new long[n];

        for (int i=0; i < n; i++) {
            num[i] = in.nextInt();
        }

        Arrays.sort(num);

        long firstProduct = num[num.length-1]*num[num.length-2]*num[num.length-3];
        long secondProduct = num[0]*num[1]*num[num.length-1];

        out.print(Math.max(firstProduct, secondProduct));
    }

    static class Reader {
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
