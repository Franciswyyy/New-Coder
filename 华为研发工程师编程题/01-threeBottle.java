
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()){
           int m = sc.nextInt();
            System.out.println(getButtle(m));
        }
    }

    public static int getButtle(int n){
        if(n == 1 || n == 0) return 0;
        if(n == 2) return 1;
        int qiuyu = 0;
        int shang = 0;
        int res = 0;
        int num = 0;
        while(num == 0 || num > 2){
            shang = (num == 0 ? n : num) / 3;
            qiuyu = (num == 0 ? n : num) % 3;
            num = shang + qiuyu;
            res = res + shang;
        }
        if(num == 2) res++;
        return res;
    }
	
	// 使用递归做
	public static int getButtle01(int n){
        if(n == 0) return 0;
        if(n == 1) return 0;
        if(n == 2) return 1;
        return getButtle01(n -2) + 1;
    }
}
