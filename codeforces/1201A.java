import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int[] m = new int[M];
        Map<Character,Integer> map = new HashMap<>();
        int score = 0;
        String[] S = new String[N];
        for(int i = 0;i<N;i++) S[i] = s.next();
        for(int i = 0;i<M;i++) m[i] = s.nextInt();

        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                map.putIfAbsent(S[j].charAt(i),0);
                map.put(S[j].charAt(i),map.get(S[j].charAt(i))+1);
            }
            int max = 0;
            for(Character k:map.keySet()){
                if(max < map.get(k))
                    max = map.get(k);
            }
            score += max*m[i];
            map.clear();
        }
        System.out.print(score);


    }

}