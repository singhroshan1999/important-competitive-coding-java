//AC
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
    static int count = 0;
    static List<Integer> lst = new LinkedList<>();
    static void flip(Map<Integer,List<Integer>> map,int[] arr,int[] goal,int i,boolean odd,boolean even,int height){
        if(height%2 == 0 && even) {
//            count++;
//            lst.add(i);
            arr[i]^= 1;
        }else if(height%2 != 0 && odd){
            arr[i]^=1;
        }

        if(height%2 == 0 && arr[i] != goal[i]){
            even=!even;
            arr[i]^=1;
            lst.add(i);
        }else if(height%2 != 0 && arr[i] != goal[i]){
            odd=!odd;
            arr[i]^=1;
            lst.add(i);
        }
        Stack<Integer> stack = new Stack<>();
        if(map.containsKey(i)) {
            for (Integer x : map.get(i)) stack.add(x);
            while (!stack.isEmpty()) {
                flip(map, arr, goal,stack.pop(), odd,even,height+1);
            }
        }
    }
    //    static dfs(Map<Integer,List<Integer>>,int[] arr)
    public static void main(String[] args) throws IOException{
//        Scanner s = new Scanner(System.in);
        Reader s=new Reader();
        int N = s.nextInt();
        int[] tree = new int[N+1];
        int[] init = new int[N+1];
        int[] goal = new int[N+1];
        Map<Integer,List<Integer>> map= new HashMap<>();
        map.put(1,new LinkedList<>());
//        for(int i : tree) System.out.println(i);
        for (int i = 1; i < N ; i++) {
            Integer x = s.nextInt(),y = s.nextInt();
            if(map.containsKey(x)) {
                map.get(x).add(y);
                map.put(y,new LinkedList<>());
            }else{
                map.get(y).add(x);
                map.put(x,new LinkedList<>());
            }
//            map.get(y).add(x);

//            tree[s.nextInt()] = s.nextInt();
        }
        for (int i = 1; i <=N ; i++) {
            init[i] = s.nextInt();
        }
        for (int i = 1; i <=N ; i++) {
            goal[i] = s.nextInt();
        }
        boolean temp;
        if(init[1] == goal[1]){
            temp = false;
        }else{
            temp = true;
            lst.add(1);
        }
        flip(map,init,goal,1,temp,false,1);
//        flip(map,init,1,true);
//        System.out.println(Arrays.toString(init));
//        Stack<Integer> stack =new Stack<>();
//        stack.add(1);
//        while(!stack.isEmpty()){
//            int i = stack.pop();
//            if(init[i] != goal[i]){ count++;lst.add(i); flip(map,init,i,true);}
//            if(map.containsKey(i))
//                for(Integer x:map.get(i)) stack.add(x);
//        }
//        System.out.println(Arrays.toString(init));
//        System.out.println(Arrays.toString(goal));
        System.out.println(lst.size());
        for(Integer i: lst) System.out.println(i);
    }
}