


题目描述：
	旋转词 一个字符串的任意部分移到了后面，称为旋转词  
	str = "12345"  其旋转词有 "12345", "23451", "34512"
	
举例： 
	
	str1 = "cdab", str2 = "abcd"   true
	str1 = "1ab2", str2 = "ab12"   false

思路：
	a b长度不一样，则必不可能为旋转词
	理解旋转词有什么特征
	那么用kmp算法实现一下，返回整数即是旋转词
	
	
public class Demo {


    public static boolean isRolation(String str1, String str2){
        if(str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        String str = str1 + str1;
        return Kmp(str, str2) != -1;         //kmp算法
        
    }

    public static void main(String[] args) {
        System.out.println(isRolation("12345", "23451"));
        System.out.println(isRolation("cdab", "ab12"));
        System.out.println(isRolation("cdab", "abcd"));
        System.out.println(isRolation("2ab1", "ab12"));
    }
}
