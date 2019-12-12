import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
class Main{
    public static void main(String[] args) throws IOException{
        int T = 200000;
        Random rand = new Random();
        FileWriter fd = new FileWriter("test_case.txt");
//        Set<Integer> s1 = new HashSet<>();
//        Set<Integer> s2 = new HashSet<>();
//        List<Integer> l = new ArrayList<>();
//        System.out.println(T+" "4);
        fd.write(T+" ");
        for(int i = 0;i<T;i++){
            fd.write(rand.nextInt(200000)+" ");
            fd.flush();
        }
        fd.close();


    }
}