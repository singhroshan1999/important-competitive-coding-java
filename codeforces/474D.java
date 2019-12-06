import java.util.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;
// WA
// TODO:
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
    static void p2(String s){
        System.out.print(s);
    }

    public static void main(String[] args) throws IOException {
        Reader s = new Reader();
        long MOD = 1000000007L;
        int _105 = 100000;
        int t = s.nextInt();
        int k = s.nextInt();
        long[] an = new long[t];
        int tcount = 0;
        long[] q = new long[_105+1];
//        Arrays.fill(q,1L);
        q[0] = 0;
        int f = 1;
        for(int i = 1;i<=_105;i++){
            if(i%k == 0) f+=k;//q[i]++;
            if(i >= k){ q[i]+=q[i-1]+f;//i-k+1;
                //
            }else{
                q[i] = 1;
            }
//            q[i]+=q[i-1];
        }
//        p(Arrays.toString(q));
        int a,b;
        while(t-->0){
            a = s.nextInt();
            b = s.nextInt();
            for(int i = a;i<=b;i++){
//                if(an[tcount]+q[i] >= MOD){ an[tcount] = (an[tcount] +q[i]);}
//                else {
                    an[tcount] += q[i];
//                }
            }
            tcount++;
        }
//        p(Arrays.toString(an));
        StringBuilder ans=new StringBuilder();
        for(int i = 0;i<an.length;i++) {
            ans.append((an[i])+"\n");
        }
        System.out.println(ans);
    }
}