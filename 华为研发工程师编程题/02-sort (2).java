

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*while(sc.hasNext()){
            int m = sc.nextInt();
            int[] arr = new int[1001];
            while(m-- != 0){
                arr[sc.nextInt()] = 1;
            }
            for(int i = 0; i < 1001; i ++){
                if(arr[i] != 0){
                    System.out.println(i);
                }
            }
        }*/


        while(sc.hasNext()){
            int m = sc.nextInt();
            boolean[] arr = new boolean[1001];
            while(m-- != 0){
                arr[sc.nextInt()] = true;
            }
            for(int i = 0; i < 1001; i ++){
                if(arr[i]){
                    System.out.println(i);
                }
            }
        }
    }
}
