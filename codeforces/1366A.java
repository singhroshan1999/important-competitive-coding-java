/**
 * CREATED BY ROSHAN SINGH
 *
 * 8:09 PM  11/06/20
 */
//TODO : XXX
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
            long a  = s.nextLong();
            long b  = s.nextLong();
            int e = 0;
            if(a == 0 || b == 0){
                o.println(0);
                continue;
            }
            if(a >= 2*b || b >= 2*a){
                o.println(Math.min(a,b));
                continue;
            }
            if(a%2 == 0 && b%2 == 0){
                e+= Math.max(a,b)/2;

            }else if(a%2 != 0 && b%2 != 0){
                e+= Math.max(a,b)/2+1;
            }else{
                if(a%2 == 0){
                    e+=a/2+1;
                }else{
                    e+=b/2+1;
                }
            }
            o.println(e);
        }
        // end
        o.close();

    }
}