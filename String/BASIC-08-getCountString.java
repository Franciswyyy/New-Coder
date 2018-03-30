

题目描述：
	给定一个字符串str，返回统计字符串
	
举例： 
	str = "aaabbadddffc"    a_3_b_2_a_1_d_3_f_2_c_1

思路：
	如果字符编码值在0-255之间，则申请一个数组，把每次出现的都存起来。
	再把出现了的字符减1，如果出现负值则返回false。
	如果字符类型很多，则直接用哈希表代替数组

字符串的统计

不用额外数组来实现
用一个Stringbuffer 转成String方法   1.构造方法new String(StringBuffer)  或者 StringBuffer.toString
String 转 StringBuffer
    1.构造方法
        new StringBuffer(String)
    2.append
        sb.append(str)

思考：
有什么好的方法能够全部统计出来每个字符出现的次数，还是必须要建立很长的数组，每


在统计字符串中给定一个整数index，求其代表的原字符串的第index个字符
这种还是老方法
    定义一个cur(表示当前的这个), num(出现了多少次), sum(总共出现了多少次)

    要清楚的知道什么时候开始是数字， 因为数字可能多位。 那就用flag
* */

public class demo07 {



    public static String getCountString(String str){
        if(str == null || str.equals("")){
            return "";
        }

        char[] chars = str.toCharArray();
        StringBuffer sb = new StringBuffer();

        sb.append(chars[0]);
        int num = 1;

        for(int i = 1; i < chars.length; i ++){
            if(chars[i] == chars[i - 1]){
                num ++;
                continue;
            }else {
                //肯定相等了，那么就开始连接了
                sb.append('_');
                sb.append(num);
                sb.append('_');
                sb.append(chars[i]);
                num = 1;
            }
        }

        sb.append('_');
        sb.append(num);

        return sb.toString();

    }


    public static char getCharAt(String str, int index){
        if(str == null || str.equals("")) return 0;

        char[] chars = str.toCharArray();
        char cur = 0;
        int num = 0;
        int sum = 0;
        boolean flag = true;  //碰到_取反, true说明是字符串，false说明是开始数了


        //还要考虑出现的数字是多位数的
        for(int i = 0; i < str.length(); i ++){
            if(chars[i] == '_'){
                flag = !flag;
            }else if(flag){  //说明就是字符了
                sum = sum + num;
                if(sum >= index){
                    return cur;
                }
                cur = chars[i];
                num = 0;

            }else{         //计入计数出现几次
                num = num * 10 + chars[i] - '0';
            }
        }

        //最后还要加一次
        return sum + num >= index ? cur : 0;
    }

    public static void main(String[] args) {
        String str1 = getCountString("aaabbbcccddd");
        System.out.println(str1);
        System.out.println(getCharAt(str1, 9));

        String str2 = getCountString("abccffeessssggh");
        System.out.println(str2);
        System.out.println(getCharAt(str2, 5));

        String str3 = getCountString("abdc");
        System.out.println(str3);
        System.out.println(getCharAt(str3, 3));

    }
}
