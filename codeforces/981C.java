import java.util.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

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
    public static void main(String[] args) throws IOException {
        Reader s = new Reader();//new Scanner(System.in);
        int N = s.nextInt();
        List<Integer>[] list = new LinkedList[N+1];
        Set<Integer> set = new HashSet<>();
        Set<Integer> tempSet = new HashSet<>();
        List<Integer> res = new LinkedList<>();
        int a,b;
        for (int i = 1; i < N; i++) {
            a = s.nextInt();
            if(list[a] == null) list[a] = new LinkedList<>();
            list[a].add(s.nextInt());
//            System.out.println(i+" "+N);
        }
//        System.out.println(Arrays.toString(list));
//        return;
        int max = 0,max_i = 0;
        for (int i = 1; i <= N; i++) {
            if(list[i] != null){
                if(list[i].size() > max){ max = list[i].size();max_i = i;}
            }
        }
        int x,y;
        for (int i = max_i; i <= N;) {
//            System.out.println("!");
            if(list[i] == null || list[i].size() == 0){i++; continue;}
//            System.out.println("#");
            tempSet.clear();
            x = i;
            y = list[i].remove(0);
            tempSet.add(x);tempSet.add(y);
            while (true){
                if(list[y] == null || list[y].size() == 0) break;
                y = list[y].remove(0); // error**
                tempSet.add(y);
            }
            res.add(x);res.add(y);
            if(set.isEmpty()){ set.addAll(tempSet);}
            else {set.retainAll(tempSet);}
//            System.out.println(set);
            if(set.size() == 0) break;
        }
//        System.out.println(res);
        if(set.size() > 0){
            System.out.println("Yes");
            System.out.print(res.size()/2);
            boolean flag = true;
            for(int i : res){
                if(flag) System.out.println("");
                System.out.print(i+" ");
                flag = !flag;
            }
        } else {
            System.out.println("No");
        }
    }
}