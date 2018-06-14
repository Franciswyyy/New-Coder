

题目描述：
	判断一个字符数组所有字符都只出现一次 
举例： 
	

思路：
	
1.时间复杂度为O(N)
    比较简单

2.在保证空间复杂度为O(1), 尽量低的时间复杂度

一个字节表示256个字符   0 - 255




public class Soultion {

    public static boolean isUnique(String str){
        if(str == null || str.equals("")) return false;

        char[] chars = str.toCharArray();
        /*int[] map = new int[256];

        for(int i = 0; i < chars.length; i ++){
            if(map[chars[i]] == 0 ){
                map[chars[i]] ++;
                continue;
            }else {
                return false;
            }
        }
        return  true;*/

        //完全可以定义一个boolean型数组
        boolean[] map = new boolean[256];    //默认为false
        for(int i = 0; i < chars.length; i ++){
            if(map[chars[i]]){
                return false;
            }
            map[chars[i]] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("adsfvxzcv"));
        System.out.println(isUnique("213sadfs"));
        System.out.println(isUnique("sdfasfcxz"));
        System.out.println(isUnique("ad"));
        System.out.println(isUnique("fsdaewr"));
        System.out.println(isUnique("12vsda"));
    }
}







