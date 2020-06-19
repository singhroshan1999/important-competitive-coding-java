/**
 * CREATED BY ROSHAN SINGH
 *
 * 8:39 PM  07/06/20
 */
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
        Reader s = new Reader();
//        Reader s = new Reader("INPUT");
        OutputStream outputStream = System.out;
//        OutputStream outputStream = new FileOutputStream("OUTPUT");
        PrintWriter o = new PrintWriter(outputStream);
        // start
        int t = s.nextInt();
        while (t-->0){
            int n = s.nextInt();
            int[][] a = new int[n][2];
            for(int i = 0;i<n;i++) a[i][0] = s.nextInt();
            for(int i = 0;i<n;i++) a[i][1] = s.nextInt();
//            Arrays.sort(a,new Comparator<int[]>(){
//                public int compare(int[] a,int[] b){
//                    if(a[1] == b[1]) return 0;
//                    return a[0]-b[0];
//                }
//            });
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n-1; j++) {
//                    if(a[j][1] == a[j+1][1]) continue;
//                    if(a[j][0] > a[j+1][0]){
//                        int[] temp = a[j];
//                        a[j] = a[j+1];
//                        a[j+1] = temp;
//                    }
//                }
//            }
//            for (int i = 0; i < n-1; i++)
//            {
//                int min_idx = i;
//                for (int j = i+1; j < n; j++) {
//
//                    if (arr[j] < arr[min_idx])
//                        min_idx = j;
//                }
//                int temp = arr[min_idx];
//                arr[min_idx] = arr[i];
//                arr[i] = temp;
//            }

            boolean flag = true;
            for (int i = 0; i <n-1 ; i++) {
                if(a[i][0] > a[i+1][0]){
                    flag = false;
                    break;
                }
            }
            int z = 0;
            int on = 0;
            for (int i = 0; i < n; i++) {
                if(a[i][1] == 0){
                    z++;
                }else{
                    on++;
                }
            }

            o.println(((on != 0 && z != 0) || flag)?"Yes":"No");
        }
        // end
        o.close();

    }
}