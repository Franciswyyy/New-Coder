import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = getAveRadix(n);
        int gcd = gcd(num, n - 2);
        System.out.println("进制的均值为：" + num/gcd + "/" + (n-2)/gcd);
    }

    private static int getAveRadix(int num){
        if(num == 1)    return 1;

        int qiuyu = 0;
        int shang = 0;
        int count = 0;  //总共几位数
        int sum = 0;
        for(int i = 2; i <= num - 1; i ++){

            shang = num/i;
            qiuyu = num%i;
            sum = sum + qiuyu;
            while(shang != 0){
                 qiuyu = shang%i;
                 shang = shang/i;
                 sum = sum + qiuyu;
            }
        }
        return sum;
    }

    private static int gcd(int a, int b){
        while(a % b != 0){
            int c = a%b;
            a = b;
            b = c;
        }
        return b;
    }
}
