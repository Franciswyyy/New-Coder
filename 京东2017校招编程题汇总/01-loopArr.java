
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i ++){
            a[i] = sc.nextInt();
        }
        int num = entryNum(a, n);
        System.out.println(num);
    }

    private static int entryNum(int[] arr, int n){
        int res = n;
        boolean[][] dp = new boolean[n][n];    // 布尔数组默认为false

        //找任意一点和它相距gap距离的点
        for(int gap = 2; gap < n - 1; gap ++){
            for(int i = 0; i < n; i ++){
                if(!dp[i][(i+gap)%n] && !dp[(i+gap)%n][i]){
                    //开始它们距离中间的否全都比它们低
                    int k = gap -1;
                    boolean b = true;
                    while (k > 0){
                        if(!(arr[(i+k)%n]<=arr[(i+gap)%n]&&arr[(i+k)%n]<=arr[i])){
                            //即数值之间的值时有大于两边的
                            b = false;
                        }
                        k--;
                    }
                    if(b){
                        dp[i][(i+gap)%n] = true;
                        dp[(i+gap)%n][i] = true;
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
