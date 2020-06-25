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
            int n = s.nextInt();
            char[] a = (s.next()).toCharArray();
            for (int i = n-1; i >=0 ; i--) {
                if(a[i] == '0') continue;
                for (int j = i+1; j < n; j++) {
                    if(a[j] == '0') {
                        if (a[i] == '1') {
                            a[j] = '3';
                            a[i] = '2';
                        } else if (a[i] == '2') {
                            a[j] = '3';
                        }
                    }
                }
                if(a[i] == '2'){
                    a[i] = '0';
                }
            }
            for (int i = 0; i < n; i++) {
                if(a[i] == '1'){
                    o.print(1);
                }else if(a[i] == '0'){
                    o.print(0);
                }
            }
            o.println("");
        }
        // end
        o.close();
    }
}