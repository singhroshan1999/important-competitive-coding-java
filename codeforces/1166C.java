import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=Math.abs(sc.nextInt());
        }
        Arrays.sort(arr);
        int i=0,j=0;
        long pairs=0;
        while(j<n)
        {
            if(arr[j]<=arr[i]*2)
                j++;
            else
            {
                pairs+=j-i-1;
                i++;
            }
        }
        while(i<n)
        {
            pairs+=n-i-1;
            i++;
        }
        System.out.println(pairs);
    }
}