import java.util.*;
class Main{
    static String pig(String i,int f){
        char[] c = new char[]{i.charAt(0)};
        String s = i.substring(1)+(new String(c)).toLowerCase()+"ay";
        if(f == 0){
        c[0] = s.charAt(0);
        s = (new String(c)).toUpperCase()+s.substring(1);}
        return s;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T = Integer.parseInt(s.nextLine());
        while(T-->0){
            String[] l= s.nextLine().split(" ");
            int f = 0;
            for(String i : l){
                System.out.print(pig(i,f++)+" ");
            }
            System.out.println("");
        }
    }
}