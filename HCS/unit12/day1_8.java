package unit12;

import java.util.Scanner;

public class day1_8 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int val = input.nextInt();
        System.out.println(num(val));

    }
    public static int num(int val){
        int count = 0;
        while (val%10!=val){
           count+=val%10;
           val = val/10;
        }
        return(count);
    }

}
