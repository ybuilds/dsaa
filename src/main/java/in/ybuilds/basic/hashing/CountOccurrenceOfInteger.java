package in.ybuilds.basic.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountOccurrenceOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, Integer> frequency = new HashMap<>();

        System.out.print("Enter size of array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];

        System.out.print("Enter array elements: ");
        for(int i=0; i<n; i++)
            arr[i] = scanner.nextInt();

        System.out.println("Computing...");
        for(int i: arr)
            frequency.put(i, frequency.getOrDefault(i, 0)+1);

        System.out.print("Enter number of queries: ");
        int q = scanner.nextInt();
        while(q-- > 0) {
            System.out.print("Enter element whose occurrence is needed: ");
            int elem = scanner.nextInt();
            System.out.println(elem + " found " + frequency.getOrDefault(elem, -1) + " times");
        }
    }
}
