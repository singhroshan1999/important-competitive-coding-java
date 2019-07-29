import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int count = 0;
        int sum = 0;
        while(N>0){
            sum+=N+(N-1)*count;
            count++;
            N--;
        }
        System.out.print(sum);
    }
}