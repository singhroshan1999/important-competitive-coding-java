import java.util.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;
class Main{
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
    static void p(String s){
        System.out.println(s);
    }
    static void p(int s){
        System.out.println(s);
    }
    static void p(long s){
        System.out.println(s);
    }
    static void p(int[] s){
        System.out.println(Arrays.toString(s));
    }
    static void p(long[] s){
        System.out.println(Arrays.toString(s));
    }
    static void p2(String s){
        System.out.print(s);
    }

    public static void main(String[] args) throws IOException {
        Reader s = new Reader();
        int n = s.nextInt();
        long[] x = new long[n+1];
        for(int i = 1;i<=n;i++) x[i] = s.nextLong();
        int q =s.nextInt();
        int[] result = new int[100000+1];
        Arrays.fill(result,-1);
        long[] m = new long[q+1];
        for(int i = 1;i<=q;i++) m[i] = s.nextLong();
        Arrays.sort(x);
//        p(x);
        int r;
        for(int i = 1; i<=q;i++){
            if(m[i] > 100000){
                p(n);
                continue;
            }
            if(result[(int)m[i]] != -1){
                p(result[(int)m[i]]);
                continue;
            }
            r = Arrays.binarySearch(x,m[i]);
            if(r > 0){
                int t = r;
                while(t<n && m[i] == x[++t]) r++;
                result[(int)m[i]] = r;
                p(r);
            }else if(r==-2){
                p(0);
            }else{
                result[(int)m[i]] = Math.abs(r)-2;
                p(Math.abs(r)-2);
            }
        }
    }
}

/* IDEAL DP SOLUTION

    public static void main(String args[])throws IOException
    {
        Reader sc=new Reader();
        PrintWriter pw=new PrintWriter(System.out);
        int n=sc.nextInt();
        int sum[]=new int[100001];
        for(int i=1;i<=n;i++)
        {
            sum[sc.nextInt()]++;
        }
        for(int i=1;i<=100000;i++)
        {
            sum[i]+=sum[i-1];
        }
        int q=sc.nextInt();
        for(int z=1;z<=q;z++)
        {
            int x=sc.nextInt();
            x=Math.min(x,100000);
            pw.println(sum[x]);
        }
        pw.close();
    }
 */