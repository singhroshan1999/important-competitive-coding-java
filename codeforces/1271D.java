/**
 * CREATED BY ROSHAN SINGH
 *
 * 11:59 AM  22/12/19
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
//        Reader s = new Reader();
        Reader s = new Reader("INPUT");
//        OutputStream outputStream = System.out;
        OutputStream outputStream = new FileOutputStream("OUTPUT");
        PrintWriter o = new PrintWriter(outputStream);
        // start
        int n = s.nextInt();
        int m = s.nextInt();
        int k = s.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[n+1];
        int[] c = new int[n+1];
        LinkedList<Integer>[] ll= new LinkedList[n+1];
        int[][] map = new int[n+1][n+1];
        int[] mp = new int[n+1];
        int[] count = new int[5000+1];
//        Map<Integer,LinkedList<Integer>> map = new TreeMap<>();
        int mc = 0;
        int mci = -1;
        int result = 0;
        for(int i = 1;i<=n;i++){
            a[i] = s.nextInt();
            b[i] = s.nextInt();
            c[i] = s.nextInt();
//            if()
            mci = (mc>a[i])?mci:c[i];
            mc = Math.max(mc,a[i]);
            count[c[i]]++;
        }
        int v,u;
        for(int i = 0;i<m;i++) {
            u = s.nextInt();
            v = s.nextInt();
            mp[v] = Math.max(u,mp[v]);
//            map[u][v] = 1;
        }
        for(int i = 1;i<=n;i++) {
            if(ll[mp[i]] == null){
                ll[mp[i]] = new LinkedList<>();
            }
            ll[mp[i]].add(i);
        }
        for(int i = 1;i<=n;i++){
            if(k>=a[i]){
                k+=b[i];
            }else{
                System.out.println(-1);
                return;
            }
        }
        o.println(k+" "+mc+" "+mci+" "+Arrays.toString(count));
        boolean f = true;
        for(int i = 5000;i>0;i--){

            if(count[i] == 0)continue;
            o.println(result);
            if(f && k-mc>0){
                result+=i*count[i];
                k-=count[i];
                count[i] = 0;
                if(k-mc<0){
                    result-=Math.abs(k-mc)*i;
                    k+=Math.abs(k-mc);
                }
                if(i == mci) {f = false;continue;}
            }
            if(!f){
//                if(i == mci) f = false;
                result+=i*count[i];
                k-=count[i];
                count[i] = 0;
                if(k<0){
                    result-=Math.abs(k)*i;
                    k+=Math.abs(k);
                }
            }
        }

        o.println(""+result);
        // end
        o.close();

    }
}