package in.ybuilds.basic.arrays;

import java.util.Scanner;

public class SumOfElements {
    public int sum(int[] arr, int n) {
        int sum = 0;
        for(int i=0; i<n; i++)
            sum += arr[i];

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SumOfElements object = new SumOfElements();

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scanner.nextInt();

        System.out.println(object.sum(arr, n));
    }
}
