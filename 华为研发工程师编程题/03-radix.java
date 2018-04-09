
import java.util.Scanner;

public class Main {

    //16转10   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){

           /*
			Java自带方法
            String str = sc.nextLine().substring(2);
            System.out.println(Integer.parseInt(str, 10));
           */



           StringBuffer sb = new StringBuffer();
           sb.append(sc.nextLine());
           String str = sb.reverse().substring(0,sb.length()-2);
            System.out.println(Integer.parseInt(str, 10));
           char[] chars = str.toCharArray();
           int sum = 0;
           for(int i = 0; i < chars.length; i ++){
               if(chars[i]>='A'&&chars[i]<='F'){
                   sum+=(Integer.valueOf(chars[i])-55)*Math.pow(16,i);
               }else {
                   sum+=(Integer.valueOf(chars[i])-48)*Math.pow(16,i);
               }
           }
            System.out.println(sum);

        }
    }
}
