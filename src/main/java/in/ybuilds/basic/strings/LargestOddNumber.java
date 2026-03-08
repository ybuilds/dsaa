package in.ybuilds.basic.strings;

import java.util.Scanner;

public class LargestOddNumber {
    public String largeOddNum(String s) {
        if (s.equals("0"))
            return "";

        int i=0;
        while(s.charAt(i) == '0') {
            i++;
            if (i == s.length())
                break;
        }

        if (i == s.length()-1)
            return "";

        s = s.substring(i);

        for(int j=s.length()-1; j>=0; j--) {
            if ((s.charAt(j)-'0')%2 != 0)
                return s.substring(0, j+1);
        }

        return "";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LargestOddNumber object = new LargestOddNumber();
        System.out.println(object.largeOddNum(scanner.next()));
    }
}
