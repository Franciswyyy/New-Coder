

题目描述：
	给定一个字符串，将整数字符转成整数值, 书写形式为32整数位，返回整数值，否则为0
	
举例： 
	str = "123"  123
	str = "023"  0
	str = "A12"  0
	str = "2147483647"    2147483647
 	str = "2147483648"	  0 (溢出了) 
思路：
	1、首先要知道32整数位正好是Integer.MAX MIN...
	2、判断一个数字字符串有效的问题
		例： 不符合规范的 A12,012  输出0
			 返回-12，还要防止连续两个--的情况
			 -0也不是有效的 ，一定是开头才会有负号

		总结：
			1.1 首个不是'-'或者不是数字字符
			1.2 首个为 '-' 但就一个或者 第一个为0  -0
			1.3 首个为0，后面的还是字符
			1.4 循环遍历每个都是数字字符
	3、越界问题
    32位的数字： -2147483648(10位)、2147483647 负数比整数大一，全部以负数计算
              当9位比其小的时候，还有的话，则必溢出了
              当9位等于的时候，则看一位如果小于-8那么也会溢出
              只有当9位等于或大于，最后一位大于等于的话，等于还得判断正负，返回。

debug调试：
        1.判断有效的一个符号或写成于
        2.在判断有效的时候，应从第二个符号开始考虑，否则当为-的时候都无效

public class Solution {

    public static boolean isVaild(String str){
        if(str == null)   return false;

        char[] chars = str.toCharArray();

        if(chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')){
            return false;
        }

        if(chars[0] == '-' && (chars.length == 1 || chars[1] == '0')){
            return false;
        }

        if(chars[0] == '0' && chars.length > 1){
            return false;
        }

        for(int i = 1; i < chars.length; i ++){
            if(chars[i] < '0' || chars[i] > '9'){
                return false;
            }
        }
        return true;
    }


    public static int convert(String str){
        if(str == null || str.equals(""))   return 0;
        if(!isVaild(str))          return 0;


        char[] chars = str.toCharArray();
        boolean flag = (chars[0] == '-' ? false : true);
        int cur = 0;
        int sum = 0;
        int result = 0;
        int qy = Integer.MIN_VALUE / 10;    //-214748364
        int qs = Integer.MIN_VALUE % 10;    //-8

        for(int i = (flag ? 0 : 1); i < chars.length; i ++){
            cur = '0' - chars[i];      //负数
            if(result < qy || (result == qy && cur < qs)){
                return 0;
            }
            result = result * 10 + cur;
        }
        //正数且为最大负数的绝对值
        if(flag && result == Integer.MIN_VALUE){
            return 0;
        }

        return flag ? -result : result;
    }

    public static void main(String[] args) {

        System.out.println(convert("2147483647"));
        System.out.println(convert("2147483648"));
        System.out.println(convert("-2147483648"));
        System.out.println(convert("-2147483649"));
    }
}
