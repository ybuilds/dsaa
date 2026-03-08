package in.ybuilds.basic.arrays;

import java.util.Scanner;

public class CheckSorted {
    public boolean arraySortedOrNot(int[] arr, int n) {
        if (n == 0 || n == 1)
            return true;

        for(int i=1; i<n; i++) {
            if (arr[i-1] > arr[i])
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CheckSorted object = new CheckSorted();

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scanner.nextInt();

        System.out.println(object.arraySortedOrNot(arr, n));
    }
}
