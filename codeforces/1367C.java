/**
 * CREATED BY ROSHAN SINGH
 *
 */
//TODO : XXX
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
            int k = s.nextInt();
            char[] a = (s.next()).toCharArray();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(a[i] == '1') arr.add(i);
            }
            int result = 0;
            System.out.println("#");
            for (int i = 0; i < n; i++) {

                if(a[i] == '0'){
                    int indx = Math.abs(Collections.binarySearch(arr,i))-1;
                    if(!arr.isEmpty()
                            && (indx >(i+k) < arr.get(indx))
                            && (i-k) > arr.get(indx-1)){
                        result++;
                        arr.add(indx,i);
                    }else if(arr.size() == 0){
                        arr.add(0,i);
                    }
                }
            }
            o.println(result);
        }
        // end
        o.close();
    }
}