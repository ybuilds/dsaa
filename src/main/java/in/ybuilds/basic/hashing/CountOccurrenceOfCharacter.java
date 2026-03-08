package in.ybuilds.basic.hashing;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountOccurrenceOfCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> frequency = new TreeMap<>();

        System.out.print("Enter string: ");
        String str = scanner.nextLine();
        char[] arr = str.toCharArray();

        System.out.println("Computing...");
        for(char i: arr)
            frequency.put(i, frequency.getOrDefault(i, 0)+1);

        System.out.print("Enter number of queries: ");
        int q = scanner.nextInt();
        while(q-- > 0) {
            System.out.print("Enter element whose occurrence is needed: ");
            char elem = scanner.next().charAt(0);
            System.out.println(elem + " found " + frequency.getOrDefault(elem, -1) + " times");
        }
    }
}
