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
        LinkedList<String> ans = new LinkedList<>();
        char[] a;
        char[] b;
        int p;
        int q;
        int counta;
        int countb;
        boolean f;
        while(n-->0){
            a = (s.next()).toCharArray();
            b = (s.next()).toCharArray();
            p=0;q=0;
//            counta = 0;countb = 0;
            f = true;
            while(p<a.length && q <b.length){
                counta = 0;countb = 0;
                if(a[p] != b[q]){
                    ans.add("NO");f = false;
                    break;
                }
                while(p<a.length-1 && a[p] == a[p+1]){ p++;counta++;}
                while(q < b.length-1 && b[q] == b[q+1]){ q++;countb++;}
                if(counta > countb){
                    ans.add("NO");f = false;
                    break;
                }
                p++;q++;
            }
            if(f && (p != a.length || q != b.length)){
                ans.add("NO");
                continue;
            }
            if(f)ans.add("YES");
        }
        StringBuilder qaz=new StringBuilder();
        for(String i : ans)
            qaz.append(i+"\n");
        System.out.println(qaz);
    }
}