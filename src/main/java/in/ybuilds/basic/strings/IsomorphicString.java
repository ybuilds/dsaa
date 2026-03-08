package in.ybuilds.basic.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IsomorphicString {
    public boolean isomorphicString(String a, String b) {
        Map<Character, Character> aMap = new HashMap<>();
        Map<Character, Character> bMap = new HashMap<>();

        for(int i=0; i<a.length(); i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);

            if (aMap.containsKey(c1) && aMap.get(c1) != c2)
                return false;

            if(bMap.containsKey(c2) && bMap.get(c2) != c1)
                return false;

            aMap.put(c1, c2);
            bMap.put(c2, c1);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IsomorphicString object = new IsomorphicString();
        String a = scanner.next();
        String b = scanner.next();

        System.out.println(object.isomorphicString(a, b));
    }
}
