import java.util.*;
public class Main {
   public static void main(String[] args){
       Scanner s = new Scanner(System.in);
       int N = s.nextInt();
       int M = s.nextInt();
       int[] Ai = new int[N];
       for(int i = 0;i<N;i++) Ai[i] = s.nextInt();
       int[] graph = new int[N+1];
       for(int i = 1;i<N;i++){
           graph[s.nextInt()] = s.nextInt();
       }


   }
   int dfs(int[] g,int m,int[] c){

   }
}