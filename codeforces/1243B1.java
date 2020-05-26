/**
 * CREATED BY ROSHAN SINGH
 *
 */
import java.io.*;
import java.util.*;
// TODO
class Main{
    static class FastScanner {  // for string + number
        BufferedReader br;
        StringTokenizer st;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
        OutputStream outputStream = System.out;
        PrintWriter o = new PrintWriter(outputStream);
        int t = s.nextInt();
        int n;
        int[] a;// = new int[26];
        int[] b;
        char[] str1,str2;
        boolean f;
        while(t-->0){
            f = false;
            n = s.nextInt();
            str1 = s.next().toCharArray();
            str2 = s.next().toCharArray();
            a = new int[26];
            b = new int[26];
            for (int i = 0;i<n;i++) {
                if(str1[i] != str2[i]) {
                    a[str1[i]-'a']++;
                    b[str2[i]-'a']++;
                }
            }
            Arrays.sort(a);
            Arrays.sort(b);
            for (int i = 0; i < 26; i++) {
                if(a[i] != b[i] || a[i]%2 != 0 && b[i] %2 != 0){
                    f = true;
                    break;
                }
            }
            if(f){
                o.println("NO");
            }else{
                o.println("YES");
            }
        }
        o.close();

    }
}