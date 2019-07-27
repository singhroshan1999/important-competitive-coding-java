import java.util.*;
public class Main{
    public static void sortbyColumn(long arr[][], int col)
    {
        Arrays.sort(arr, new Comparator<long[]>() {
            @Override
            public int compare(final long[] entry1,
                               final long[] entry2) {
                if (entry1[col] > entry2[col])
                    return 1;
                else
                    return -1;
            }
        });
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int S = s.nextInt();
        int B = s.nextInt();
        long[] A = new long[S];

        long[][] DG = new long[B][2];
        for(int i = 0;i<S;i++)
            A[i] = s.nextInt();
        for(int i = 0;i<B;i++) {
            DG[i][0] = s.nextLong();
            DG[i][1] = s.nextLong();
        }
        sortbyColumn(DG,0);
        long[] D = new long[B];
        for(int i= 0;i<B;i++)
            D[i] = DG[i][0];
        long[] G = new long[B];
        G[0] = DG[0][1];
        for(int i= 1;i<B;i++)
            G[i] = G[i-1]+DG[i][1];
        for(long i:A){
            int bs = Arrays.binarySearch(D,i);
            int indx;
            long gold=0;
            if(bs == -1){
                System.out.print(0+" ");
                continue;
            }
            else if(bs<0){
                indx=Math.abs(bs)-2;
            }else{
                indx = bs;
            }
            System.out.print(G[indx]+" ");
        }
    }
}