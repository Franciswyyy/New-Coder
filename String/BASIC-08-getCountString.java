

题目描述：
	1. 给定一个字符串str，返回统计字符串
	2. 在给定一个统计字符串，再给定一个整数，返回所代表的的原始字符串上的字符
举例： 
	str = "aaabbadddffc"    a_3_b_2_a_1_d_3_f_2_c_1
	a_3_b_100   第0个字符为'a' 第50个位'b'

思路：
	先生成统计字符串，遍历一次，用StringBuffer来接收。
	
	1. StringBuffer转String方法。 1. 构造方法 new String(StringBuffer)     2. StringBuffer.toString
	2. String转StringBuffer       1. 构造方法 new StringBuffer(String)       2.append  sb.append(str)

	统计的话：
	1. 清楚的知道什么时候开始是数字，因为数字可以有很多位，用flag来显示
	定义 一个cur表示当前， num出现了多少次 (当前多少,可以是多位的数字)， sum总共多少


public class Soultion {

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
        boolean flag = true;     //碰到_取反, true说明是字符串，false说明是开始数了


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
