package richard;

import java.util.ArrayList;
import java.util.Scanner;

public class richard {
    public static void main(String[] agrs) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter name of bar:");
        String val1 = in.next();
        System.out.println("Enter values");
        int value1 = in.nextInt();
        System.out.println("Enter name of bar:");
        String val2 = in.next();
        System.out.println("Enter values");
        int value2 = in.nextInt();
        System.out.println("Enter name of bar:");
        String val3 = in.next();
        System.out.println("Enter values");
        int value3 = in.nextInt();
        System.out.println("Enter name of bar:");
        String val4 = in.next();
        System.out.println("Enter values");
        int value4 = in.nextInt();
        System.out.println("Enter name of bar:");
        String val5 = in.next();
        System.out.println("Enter values");
        int value5 = in.nextInt();
        String bar1 = "";
        String bar2 = "";
        String bar3 = "";
        String bar4 = "";
        String bar5 = "";
        for (int i = 0; i < value1; i++){
            bar1 += "*";
        }
        for (int i = 0; i < value2; i++){
            bar2 += "*";
        }
        for (int i = 0; i < value3; i++){
            bar3 += "*";
        }
        for (int i = 0; i < value4; i++){
            bar4 += "*";
        }
        for (int i = 0; i < value5; i++){
            bar5 += "*";
        }
        System.out.println(val1 + " " + bar1);
        System.out.println(val2 + " " + bar2);
        System.out.println(val3 + " " + bar3);
        System.out.println(val4 + " " + bar4);
        System.out.println(val5 + " " + bar5);

    }
}


