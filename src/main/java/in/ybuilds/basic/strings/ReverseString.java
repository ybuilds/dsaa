package in.ybuilds.basic.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseString {
    public void reverseString(List<Character> s) {
        int i=0, j=s.size()-1;
        while(i < j) {
            char temp = s.get(j);
            s.set(j, s.get(i));
            s.set(i, temp);

            i++;
            j--;
        }
    }

    public boolean palindromeCheck(String s) {
        int i=0, j=s.length()-1;

        while(i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReverseString object = new ReverseString();
        String str = scanner.nextLine();

        List<Character> s = new ArrayList<>();
        for(char c: str.toCharArray())
            s.add(c);

        object.reverseString(s);
        System.out.println(s);
    }
}
