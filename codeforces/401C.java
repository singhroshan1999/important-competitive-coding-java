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
    static void p2(String s){
        System.out.print(s);
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int[] ans = new int[n+m];
        int count = 0;
        if(2*n > m){ ans[count++] = 0; n--;}
        while(m >= 1 && n >= 1){

            if(2*n <= m){
                ans[count++] = 1;
                ans[count++] = 1;
                ans[count++] = 0;
                m--;m--;n--;
            } else{
                if(ans[count-1] == 0){
                    ans[count++] = 1;
                    ans[count++] = 0;
                    m--;
                    n--;
                }else{
                    ans[count++] = 0;
                    ans[count++] = 1;
                    m--;
                    n--;
                }
            }
        }
        if(m >= 1 || n >= 1){
            if(ans[count-1] == 1){
                if(n == 1){
                    ans[count++] = 0;
                    n--;
                }else{
                    p(-1);
                    return;
                }
            }else{
                if(m == 2){
                    ans[count++] = 1;
                    ans[count++] = 1;
                    m-=2;
                }else if(m == 1){
                    ans[count++] = 1;
                    m--;
                } else{
                    p(-1);
                    return;
                }
            }
        }
        StringBuilder qaz=new StringBuilder();
        for(int i : ans)
            qaz.append(i+"");
        System.out.println(qaz);
    }
}