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
            Queue<Character> stack = new LinkedList<>();
            Map<Integer,Integer> map = new HashMap<>();
            char x = a[0];
            int indx = 0;
            map.put(indx,1);
            stack.add(x);
            for (int i = 1; i < n; i++) {
                if(a[i] == x){
                    map.put(indx,map.get(indx)+1);
                    continue;
                }
                if(x == '0' && stack.peek() == '1'){
                    map.put(indx-1,0);
                }
                indx++;
                map.put(indx,1);
                x = a[i];
                stack.add(x);
            }
            System.out.println(map);
            x = stack.remove();
            o.print(x);
            indx = 0;
            while (!stack.isEmpty()){
                if(stack.peek() == '0'){
                    for (int i = 0; i < map.get(indx); i++) {
                        o.print(0);
                    }
                    stack.remove();
                    indx++;
                    if(!stack.isEmpty()){ stack.remove();indx++;}
                }else{
                    for (int i = 0; i < map.get(indx); i++) {
                        o.print(1);
                    }
                    stack.remove();
                    indx++;
//                    o.print(stack.remove());
                }
            }
            o.println("");
        }
        // end
        o.close();
    }
}