

题目描述：
	替换字符串中连续出现的指定字符串
	
举例： 
	str = "123abc", from = "abc" to = "4567"   返回1234567
	str = "123", from = "abc" to = "456"     返回123
	str = "123abcabc", from = "abc" to = "X"   返回123X

思路：
	把from子串找出来然后替换掉，再用字符串去连接起来，因为并不知道替换的子串有多长，所以空间复杂度并不为o(1)
	常见的定义一个从起始开始匹配	
		1. 怎么判断连续的两个子串 ---  不需要，全部换成0(空字符), 这样再遍历一边的话就全部舍弃
		2. 怎么遍历一次就连接起来 ---  只要碰到了一个0就连接，后面连续的0句不管了
		
	match = (match == -1 ? i : match);         第一次赋值的常用写法
	字符串的 != 与 !equals    对于null用== 比较，equals是方法，不能用null去调用
	
	字符的空表示0   而字符串表示空时null, 而""表示空串，有地址，长度为0 
	

public class Demo {

    public static String replace(String str, String from, String to){
        if(str == null || from == null || str.equals("") || from.equals("")){
            return str;
        }

        char[] cs = str.toCharArray();
        char[] cf = from.toCharArray();

        int match = 0;

        for(int i = 0; i < cs.length; i ++){
            if(cs[i] == cf[match ++] ){
               if(match == cf.length){
                   clear(cs, i, match);
                   match = 0;
               }
            }else{
                match = 0;
            }
        }


        String res = "";
        String cur = "";
        for(int i = 0; i < cs.length; i ++){
            if(cs[i] != 0){
                cur = cur + String.valueOf(cs[i]);
            }

            if(cs[i] == 0 && (i == 0 || cs[i - 1] != 0)){    //当为空串，要不在第一个，要不前面的不为空串
                res = res + cur;
                cur = "";
                res = res + to;
            }
        }
        if(!cur.equals("")){                //字符串的 ！= 和equals的区别
            res = res + cur;
        }
        return res;

        /*StringBuffer sb = new StringBuffer();
        for(int i = 0; i < cs.length; i ++){
            while(cs[i] == 0){

            }
            sb.append(cs[i]);
        }*/

    }

    //字符串中在i处向前走j，全部置于0
    public static void clear(char[] chars, int i , int j){
        int n = 0;
        while(n < j){
            chars[i - n] = 0;
            n++;
        }
    }


    public static void main(String[] args) {
        System.out.println(replace("123abc", "abc", "4567"));
        System.out.println(replace("123", "abc", "asdfghj"));
        System.out.println(replace("123abcabc", "abc", "X"));
    }
}
