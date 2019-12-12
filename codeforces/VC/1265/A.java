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
        int t = s.nextInt();
        char[] str;
        String[] ans = new String[t];
        int count = 0;
        boolean f = true;
        while(t-->0){
            str = (s.next()).toCharArray();
            if(str.length == 1) {ans[count++] = "a";continue;}
            if(str[0] == '?' && str[1] == '?') str[0] = 'a';
            if(str[str.length-1] == '?' && str[str.length-2] == '?') str[str.length-1] = 'c';
            if(str[0] == '?') str[0] = (char)('a'+(str[1]+1)%3);
            if(str[str.length-1] == '?') str[str.length-1] = (char)('a'+(str[str.length-2]+1)%3);
            for(int i = 0;i<str.length-1;i++){
                if(str[i+1] == '?'){
                    if(str[i] == 'a' && str[i+2] == 'c' || str[i] == 'c' && str[i+2] == 'a') str[i+1] = 'b';
                    if(str[i] == 'a' && str[i+2] == 'b' || str[i] == 'b' && str[i+2] == 'a') str[i+1] = 'c';
                    if(str[i] == 'b' && str[i+2] == 'c' || str[i] == 'c' && str[i+2] == 'b') str[i+1] = 'a';
                    if(str[i+1] == '?') str[i+1] = (char)('a'+(str[i]+1)%3);
                }
            }
//            p(Arrays.toString(str));
            ans[count++] = new String(str);
            for(int i = 0;i<str.length-1;i++){
                if(str[i] == str[i+1]){
                    ans[count-1] = "-1";
                    break;
                }
            }
        }


        StringBuilder qaz=new StringBuilder();
        for(String i : ans)
            qaz.append(i+"\n");
        System.out.println(qaz);
    }
}