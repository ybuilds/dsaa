package in.ybuilds.basic.arrays;

import java.util.Scanner;

public class CountOddInArray {
    public int countOdd(int[] arr, int n) {
        int count = 0;

        for(int i=0; i<n; i++) {
            if (arr[i]%2 != 0)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CountOddInArray object = new CountOddInArray();

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scanner.nextInt();

        System.out.println(object.countOdd(arr, n));
    }
}
