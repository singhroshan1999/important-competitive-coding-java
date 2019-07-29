import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        int[] a = new int[N];
        int[] cst = new int[N-1];
        int cost = 0;
        for(int i=0;i<N;i++)
            a[i] = s.nextInt();
        for(int i=1;i<N;i++)
            cst[i-1] = a[i]-a[i-1];
        Arrays.sort(cst);
        for(int i = 0;i<N-K;i++)
            cost+=cst[i];
        System.out.print(cost);
    }
}