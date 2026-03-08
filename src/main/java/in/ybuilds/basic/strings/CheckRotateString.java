package in.ybuilds.basic.strings;

import java.util.Scanner;

public class CheckRotateString {
    public boolean rotateString(String str, String goal) {
        for(int i=0; i<str.length(); i++) {
            str = str.substring(1) + str.charAt(0);
            if(str.equals(goal))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckRotateString object = new CheckRotateString();
        String str = scanner.next();
        String goal = scanner.next();
        System.out.println(object.rotateString(str, goal));
    }
}
