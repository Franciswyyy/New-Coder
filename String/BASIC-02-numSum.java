
题目描述：
	给出一个字符串Str，求其中的全部数字串所代表的的数字之和
	忽略其他的数字，-奇数为负，偶数就为正
	
要求：
	空间复杂度O(1), 时间O(N)
	
举例： 
	str1 = "A1CD2E33"     返回36 
	str1 = "A-1B2W--D6"   返回7  

思路：
	1. '-' 出现的次数怎么判断
	2. 值该怎么保存
	3. 字符123变成数字123
	4. 当-之后不是数字的话，一切要重置
	5. 如果以数字结尾的话，遍历完后还要累加

import java.util.Scanner;

//求字符串数字的和
public class Demo {

    public static int numSum(String str) {
       if(str == null || str.length() < 0)   return 0;

       char[] chars = str.toCharArray();
       int result = 0;
       int sum = 0;
       boolean flag = true;
       for(int i = 0; i < str.length(); i ++){
           int cur = chars[i] - '0';       //判断字符是数字的方法
           if(cur < 0 || cur > 9){
               result = result + sum;
               sum = 0;
               if(chars[i] == '-' ){
                   if(chars[i - 1] == '-' || i > 0){
                       flag = !flag;
                   }else{
                       flag = false;
                   }
               }else{
                   flag = true;
               }
           }else{
                sum = sum * 10 + (flag ? cur : -cur);
           }
       }
        result = result + sum;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            System.out.println(numSum(str1));
        }
    }
}

