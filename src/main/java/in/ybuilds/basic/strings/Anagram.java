package in.ybuilds.basic.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    public boolean anagramStrings(String s, String t) {
        Map<Character, Integer> frequency = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) - 1);
        }

        for(int i: frequency.values()) {
            if (i != 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Anagram object = new Anagram();
        String s = scanner.next();
        String t = scanner.next();
        System.out.println(object.anagramStrings(s, t));
    }
}
