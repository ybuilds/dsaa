package in.ybuilds.basic.strings;

import java.util.Scanner;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] str) {
        String prefix = str[0];

        int i, j;
        for(i=1; i<str.length; i++) {
            String curr = str[i];
            for(j=0; j<Math.min(prefix.length(), curr.length()); j++) {
                if (curr.charAt(j) != prefix.charAt(j))
                    break;
            }
            prefix = prefix.substring(0, j);
        }

        return prefix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LongestCommonPrefix object = new LongestCommonPrefix();
        int n = scanner.nextInt();
        String[] str = new String[n];

        for(int i=0; i<n; i++)
            str[i] = scanner.next();

        System.out.println(object.longestCommonPrefix(str));
    }
}
