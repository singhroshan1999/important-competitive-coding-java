import java.util.*;
public class Main{
    public static void main(String[] args){
        Random rand = new Random();
        int A = 25539  ;
        int B = 29221;
        System.out.println(A+" "+B);
        while(A>0) {
            System.out.print(rand.nextInt(1000000000) + " ");
        A--;
        }
        System.out.println("");
        while(B>0) {
            System.out.print(rand.nextInt(1000000000) + " " + rand.nextInt(10000)+" ");
        B--;
        }


    }
}