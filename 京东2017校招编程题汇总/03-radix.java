import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int N = sc.nextInt();
            System.out.println(getLucky(N));
        }
    }


    private static int getLucky(int num){
        if (num < 0) return 0;
        if (num == 1 || num == 0) return 1;

        int res = 0;
        for(int i = 2; i <= num; i ++){
            if(getRadix(i,2) == getRadix(i, 10)){
                res ++;
            }
        }
        return res+1;  //直接把1加进去
    }

    private static int getRadix(int num, int k){
        int sum = 0;
        int shang = num / k;
        int qiuyu = num % k;
        sum += qiuyu;
        while(shang != 0){
            qiuyu = shang % k;
            shang = shang / k;
            sum += qiuyu;
        }
        return sum;
    }


}
