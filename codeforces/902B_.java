import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.*;
//AC
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
    static int count = 1;
    static void ps(String s){
        System.out.println(s);
    }
    static void pi(int s){
        System.out.println(s);
    }
    static void p(String s){
        System.out.print(s);
    }
    static void dfs(boolean[][] p,int[] c,int[] color,int s){
        if(color[s] == c[s]) return;
//        count++;
//        boolean[] v = new boolean[c.length+1];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        color[s] = c[s];
        while(!stack.isEmpty()){
            int u = stack.pop();
//            if(color[u] != c[u]) {
                color[u] = c[u];
//                count++
//            }
            for(int i = 1;i<p[u].length;i++){
                if(p[u][i] == true){
                    if(color[u] != c[i]) count++;
                    stack.push(i);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        Reader s = new Reader();//new Scanner(System.in);
        int n = s.nextInt();
        boolean[][] p = new boolean[n+1][n+1];
        int[] c = new int[n+1];
        int[] color = new int[n+1];
        for(int i = 2;i<=n;i++)
            p[s.nextInt()][i] = true;
        for(int i = 1;i<=n;i++)
            c[i] = s.nextInt();
//        for(int i = 1;i<=n;i++){
            dfs(p,c,color,1);
//        }
//        ps(Arrays.toString(color));
        pi(count);

    }
}