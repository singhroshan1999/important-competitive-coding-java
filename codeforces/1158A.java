import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] bs = new int[n];
        int[] gs = new int[m];
        int maxBoy = -1;
        long minGive = 0;
        long budget = 0;
        for (int i = 0; i < n; i++) {
            bs[i] = sc.nextInt();
            maxBoy = Math.max(maxBoy, bs[i]);
            minGive += ((long) bs[i]) * m;
        }
        int minGirl = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            gs[i] = sc.nextInt();
            minGirl = Math.min(minGirl, gs[i]);
        }
        if (maxBoy > minGirl) {
            System.out.println(-1);
            return;
        }
        long rem = 0;
        Arrays.sort(bs);
        int boyI = n - 1;
        int c = 0;
        for (int i = 0; i < m; i++) {
            if (boyI < 0) {
                System.out.println(-1);
                return;
            }
            if (gs[i] > maxBoy) {
                rem += gs[i] - bs[boyI];
                c++;
            }
            if (c == m - 1) {
                c = 0;
                boyI--;
            }
        }
        System.out.println(minGive + rem);
    }
}