import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int W = s.nextInt();
        if(W == 2){ System.out.print("NO");}
        else{
        String[] str = new String[]{"YES","NO"};
        System.out.print(str[W%2]);}
    }
}