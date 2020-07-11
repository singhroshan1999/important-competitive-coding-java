/**
 * CREATED BY ROSHAN SINGH
 *
 * 9:30 PM  04/07/20
 */
// TODO : xxx
import java.io.*;
import java.util.*;
class Main{
    static class Reader // for number only problems
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
    public static void main(String[] args) throws IOException {
//        Reader s = new Reader();
        Scanner s = new Scanner(System.in);
//        Reader s = new Reader("INPUT");
        OutputStream outputStream = System.out;
//        OutputStream outputStream = new FileOutputStream("OUTPUT");
        PrintWriter o = new PrintWriter(outputStream);
        // start
        int t = s.nextInt();
        while (t-->0) {
            int n = s.nextInt();
            int m = s.nextInt();
            int[][] a = new int[n][m];
            PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (!flag) break;
                for (int j = 0; j < m; j++) {
                    long x = s.nextLong();
                    if (x > 4) {
                        flag = false;
                        break;
                    }
                    a[i][j] = (int)x;
                    if (a[i][j] > 0) {
                        pq.add(new int[]{(int) a[i][j], i, j});
                    }
                }
            }

            while (!pq.isEmpty()) {
                int[] temp = pq.remove();
                if (temp[0] > 0 && temp[1] - 1 >= 0 && a[temp[1] - 1][temp[2]] == 0) {
                    temp[0]--;
                    a[temp[1] - 1][temp[2]] = 1;
                }
                if (temp[0] > 0 && temp[1] + 1 < n && a[temp[1] + 1][temp[2]] == 0) {
                    temp[0]--;
                    a[temp[1] + 1][temp[2]] = 1;
                }
                if (temp[0] > 0 && temp[2] - 1 >= 0 && a[temp[1]][temp[2] - 1] == 0) {
                    temp[0]--;
                    a[temp[1]][temp[2] - 1] = 1;
                }
                if (temp[0] > 0 && temp[2] + 1 < m && a[temp[1]][temp[2] + 1] == 0) {
                    temp[0]--;
                    a[temp[1]][temp[2] + 1] = 1;
                }
                if(temp[0] != 0){
                    flag = false;
                    break;
                }
            }
            if(!flag){
                System.out.println("NO");
            }else {
                System.out.println("YES");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        System.out.print(a[i][j] + " ");
                    }
                    System.out.println("");
                }
            }
        }
        // end
        o.close();

    }
}