/**
 * CREATED BY ROSHAN SINGH
 *
 */
import java.io.*;
import java.util.*;
class Main{
    static class FastScanner {  // for string + number
        BufferedReader br;
        StringTokenizer st;
        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastScanner(String file)  throws IOException{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException  e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
        double nextDouble() {
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static void main(String[] args) throws IOException {
        FastScanner s = new FastScanner();
//        FastScanner s = new FastScanner("INPUT");
        OutputStream outputStream = System.out;
//        OutputStream outputStream = new FileOutputStream("OUTPUT");
        PrintWriter o = new PrintWriter(outputStream);
        // start
        int t = s.nextInt();
        while (t-->0){
            char[] a = (s.next()).toCharArray();
            Map<Integer,Integer> map = new HashMap<>();
            int count = 0,min = Integer.MAX_VALUE;
            for (int i = 0; i < a.length; i++) {
                if(a[i] == '+'){
                    count++;
                }else{
                    count--;
                }
                min = Math.min(min,count);
                if(count>= 0){
                    map.putIfAbsent(0,i);
                }else{
                    map.putIfAbsent(count,i);
                }
            }
            long res = 0;
            while (min < 0){
                if(!map.containsKey(min)) continue;
                res+=map.get(min)+1;
                min++;
            }
            res+=a.length;
            o.println(res);
        }
        // end
        o.close();
    }
}