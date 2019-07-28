import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int K = s.nextInt();
        int count = 0;
        int k2 = K;
        int a = 0;
        while(K>0){
            a = s.nextInt();
            if(a == 0)break;
            count++;
            K--;
        }
        int x;
        while(N-k2>0){
            x = s.nextInt();
            if(x != a || x == 0)break;
            count++;
        N--;
        }
            System.out.print(count);
    }
}