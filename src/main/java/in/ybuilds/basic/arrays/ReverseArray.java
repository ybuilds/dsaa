package in.ybuilds.basic.arrays;

import java.util.Scanner;

public class ReverseArray {
    public void reverse(int[] arr, int n) {
        int i=0, j=n-1;

        while(i <= j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;

            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReverseArray object = new ReverseArray();

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = scanner.nextInt();

        object.reverse(arr, n);
        for(int i: arr)
            System.out.print(i + " ");
    }
}
