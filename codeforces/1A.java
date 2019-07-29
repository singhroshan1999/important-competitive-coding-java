import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        long M = s.nextLong();
        long N = s.nextLong();
        long A = s.nextLong();
        long resultA = 0;
        long resultB = 0;
        long modM;
        long modN;
        if(M%A == 0){
            modM = 0;
        }else{
            modM = 1;
        }
        if(N%A == 0){
            modN = 0;
        }else{
            modN = 1;
        }
        if(M>A && N>A) {
            resultA = M/A+modM;
            resultB = N/A+modN;
        } else if(M>A && N<=A){
            resultA = M/A+modM;
            resultB = 1;
        } else if(M<=A && N>A){
            resultA = 1;
            resultB = N/A+modN;
        } else{
            resultA = 1;
            resultB = 1;
        }
        System.out.print(resultA*resultB);
    }
}