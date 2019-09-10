import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        Map<Integer,List<Integer>> map = new TreeMap<>();
        map.put(1,new ArrayList<>());
        int next;
        for (int i = 2; i < N+1; i++) {
            next = s.nextInt();
            if(map.containsKey(next)){
                map.get(next).add(i);
            }else{
                map.put(next,new ArrayList<>());
                map.get(next).add(i);
            }
        }
//        for(Integer i : map.keySet()){
//            System.out.println(map.get(i));
//        }
        for(Integer i:map.keySet()){
            if(map.get(i).size() < 3){
                System.out.println("No");
                return;
            }else{
                int count = map.get(i).size();
                for(Integer j : map.get(i)){
                    if(map.containsKey(j)){
                        count--;
                    }
                    if(count < 3){
                        System.out.println("No");
                        return;
                    }
                }
            }
        }
        System.out.println("Yes");
    }
}