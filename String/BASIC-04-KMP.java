

描述：
	给两个字符串，一个文本串str，一个模式串par，长度分别为N和M
	如果字符串str包含par，则返回par在str中的开始位置，不含则返回-1
	
举例： 
	str = "acbc", par = "bc"   返回2
	str = "acbc", par = "bcc"  返回-1

思路：
	时间复杂度 O(M)(求解数组next的过程) + O(N)(匹配过程) 由于N>M 则O(N)
	
	1. 理解next的数组的作用，知道前后缀最大公共长度
	2. 匹配相同的就走，不同的就退回去
	3. 关键是求next数组
	
	（详细查笔记）
	
	


public class KMP {

    public static int getIndex(String str, String par){
        if(str == null || par == null || par.length() < 1 || str.length() < par.length()){
            return -1;
        }

        char[] s = str.toCharArray();
        char[] p = par.toCharArray();
        int[] next = getNext(par);

        //i代表普通串，j代表匹配串
        int i = 0;
        int j = 0;

        while(i < s.length && j < p.length){
            // 当par只有一个字符的话，通过这个条件j == -1才能进入方法体内
            if(j == -1 || s[i] == p[j]){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }

        return j == p.length ? i - j : -1;
        /*
        if(j == p.length){
            return i - j;
        }else{
            return -1;
        }
        */

    }


    public static int[] getNext(String par) {

        if (par == null) return null;
        if (par.length() == 1) return new int[]{-1};

        char[] c = par.toCharArray();
        int[] next = new int[c.length];

        next[0] = -1;
        next[1] = 0;

        //定义前后缀
        int i = 0;
        int j = 2;

        while(j < next.length){
            if(c[j - 1] == c[i]){
                next[j ++] = ++ i;
            }else if(i > 0){
                i = next[i];
            }else{
                next[j ++] = 0;
            }
        }
        return next;
    }


    public static void main(String[] args) {
        System.out.println(getIndex("abbnds", "b"));
        System.out.println(getIndex("asdvxzvxz", "vxz"));
        System.out.println(getIndex("sgsdhgf", "gsd"));
        System.out.println(getIndex("ytgbvxa", "gbv"));
        System.out.println(getIndex("ponvbml", "nvbma"));

    }
}
