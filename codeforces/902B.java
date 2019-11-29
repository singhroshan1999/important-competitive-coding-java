import java.util.*;
class Main{
    static int count = 0;
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
        count++;
//        boolean[] v = new boolean[c.length+1];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        while(!stack.isEmpty()){
            int u = stack.pop();
            color[u] = c[s];
            for(int i = 1;i<p[u].length;i++){
                if(p[u][i] == true){
                    stack.push(i);
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        boolean[][] p = new boolean[n+1][n+1];
        int[] c = new int[n+1];
        int[] color = new int[n+1];
        for(int i = 2;i<=n;i++)
            p[s.nextInt()][i] = true;
        for(int i = 1;i<=n;i++)
            c[i] = s.nextInt();
        for(int i = 1;i<=n;i++){
            dfs(p,c,color,i);
        }
//        ps(Arrays.toString(color));
        pi(count);

    }
}