

题目描述：
	给定两个字符串str1和str2，如果两者中出现的字符种类一样且出现的次数也一样，则称为变形词
	
举例： 
	str1 = "123", str2 = "231"   true
	str1 = "123", str2 = "2331"  false

思路：
	如果字符编码值在0-255之间，则申请一个数组，把每次出现的都存起来。
	再把出现了的字符减1，如果出现负值则返回false。
	如果字符类型很多，则直接用哈希表代替数组

import java.util.Scanner;


public class Demo {

    public static boolean isDeformation(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() != str2.length()){
            return false;
        }

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        int[] map = new int[256];

        for(int i = 0; i < chars1.length; i ++){
            map[chars1[i]]++;
        }

        for(int i = 0; i < chars2.length; i ++){
            if(map[chars2[i]] -- == 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            System.out.println(isDeformation(str1, str2));
        }

    }
}
