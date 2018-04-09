import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<Integer>();
            for(int i = 0; i < m+n; i ++){
                set.add(sc.nextInt());
            }
            Iterator<Integer> iter = set.iterator();
            while(iter.hasNext()){
                System.out.print(iter.next());
                if(iter.hasNext()){
                    System.out.print(" ");
                }
            }
        }
    }
}
