package in.ybuilds.basic.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseString {
    public ArrayList<Character> reverseString(int i, int j, ArrayList<Character> s) {
        if (i > j)
            return null;

        char temp = s.get(j);
        s.set(j, s.get(i));
        s.set(i, temp);

        return reverseString(i+1, j-1, s);
    }

    public boolean palindromeCheck(int i, int j, String s) {
        if (i > j)
            return true;

        if (s.charAt(i) != s.charAt(j))
            return false;

        return palindromeCheck(i+1, j-1, s);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReverseString object = new ReverseString();
        ArrayList<Character> s = new ArrayList<>();
        for(char ch: scanner.next().toCharArray())
            s.add(ch);

        object.reverseString(0, s.size()-1, s);
        System.out.println(s);

        String palindrome = scanner.next();
        System.out.println(object.palindromeCheck(0, palindrome.length()-1, palindrome));
    }
}
