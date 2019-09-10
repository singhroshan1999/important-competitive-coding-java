import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Map<Integer,List<Integer>> map = new TreeMap<>();
        int N = s.nextInt();
        int[] C = new int[N+1];
        int in;
        for (int i = 1; i <= N; i++) {
            in = s.nextInt();
            if(!map.containsKey(in)) map.put(in,new LinkedList<>());
            map.get(in).add(i);
            C[i] = s.nextInt();
        }
//        for(int  i : C){
//            System.out.println(i);
//        }
        boolean flag,flag2 = false;
        for(int i=1;i<C.length;i++){
            flag = true;
            if(C[i] == 1){
                if(!map.containsKey(i)){
                    System.out.print(i+" ");
                    flag2 = true;
                    continue;
                }
                for(Integer j : map.get(i)){
//                    System.out.println(map.get(i));
//                    System.out.println(C[j]);
                    if(C[j] == 0) {flag = false;break;}
                }

                if(flag) {flag2 = true;System.out.print(i+" ");}
            }
        }
        if(!flag2) System.out.print(-1);
    }
}