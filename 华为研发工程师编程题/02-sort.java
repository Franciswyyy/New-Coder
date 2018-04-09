
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] a = new int[n];
            TreeSet<Integer> set = new TreeSet<Integer>();
            for(int i = 0; i < n; i++){
                set.add(sc.nextInt());
            }

            /*while(!set.isEmpty()){
                System.out.println(set.pollFirst());
            }*/
			
            Iterator iter = set.iterator();
            while(iter.hasNext()){
                System.out.println(iter.next());
            }
        }

    }
}
