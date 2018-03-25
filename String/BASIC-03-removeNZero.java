

题目描述：
	去掉字符串中连续出现的N个0的子串
		

举例： 
	str1 = "A00B"  N = 2      返回"AB" 
	str1 = "A0000B000" N = 3  返回"A0000B"  

思路：
	1. 字符0初始位置保存，满足条件或不满足条件重置
	2. 当为字符0可以置成0   字符' '和0  以及字符串null和" "
	3. 最后一次循环，把0的都删除，再连接起来


import java.util.Scanner;


public class Demo {

    public static String removeNZero(String str, int N){
        if(str == null || str.length() < 0)  return null;
        if(N < 1 )    return str;

        char[] chars = str.toCharArray();

        int count = 0;
        int start = -1;
        for(int i = 0; i < chars.length; i ++){
            if(chars[i] == '0'){
                start = (start == -1) ? i : start;
                count ++;
            }else {
                if(count == N){
                    while(count -- != 0){
                        chars[start ++] = 0;
                    }
                }
                count = 0;
                start = -1;
            }
        }
        if(count == N){
            chars[start ++] = 0;
        }


        //合起来
        char[] c = new char[chars.length];
        int sum = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == 0){
                sum ++;
                continue;
            }
            c[i - sum] = chars[i];
        }

        return String.valueOf(c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*
		while (sc.hasNext()) {
            String str = sc.nextLine();
            int N = sc.nextInt();
            System.out.println(removeNZero(str, N));
        }
		*/

        String str1 = "qwe000qwe000qe12qwe0012qwerq00ewqewq000";
        int N1 = 2;

        String str2 = "saf00dsaf  000fsdaf00fdasf 00fsad";
        int N2 = 3;

        System.out.println(removeNZero(str1, N1));
        System.out.println(removeNZero(str2, N2));
        char c2 = ' ';
        char c1 = 0;
        System.out.println(c1);
        System.out.println(c2);
    }
}

