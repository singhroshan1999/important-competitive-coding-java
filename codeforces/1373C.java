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
//            Arrays.sort(a);
//            for (int i = 0; i < a.length / 2; i++) {
//                char temp = a[i];
//                a[i] = a[a.length - i - 1];
//                a[a.length - i - 1] = temp;
//            }
            int countP = 0;
            int countM = 0;
            for (int i = 0; i < a.length; i++) {
                if(a[i] == '+'){
                    countP++;
                }else{
                    countM++;
                }
            }
            int count = 0;//countM - countP;
//            System.out.println(Arrays.toString(a));
            int count2 = 0;
            long res = 0;
            while (true){
                int cur = count2;
                boolean ok = true;
                for(char i : a){
                    res++;
                    if(i == '+'){
                        cur++;
                    }else{
                        cur--;
                    }
                    if(cur < 0){
                        ok = false;
                        break;
                    }
                }
                count--;
                count2++;
//                System.out.println("->"+res);
                if(ok) break;
            }
            o.println(res+" "+count2);
        }
        // end
        o.close();
    }
}