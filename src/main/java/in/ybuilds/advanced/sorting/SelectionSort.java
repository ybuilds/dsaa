package in.ybuilds.advanced.sorting;

import java.util.Scanner;

public class SelectionSort {
    public int[] selectionSort(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            for(int j=i; j<nums.length; j++) {
                if (nums[j] <= min) {
                    min = nums[j];
                    minIndex = j;
                }
            }

            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SelectionSort object = new SelectionSort();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        System.out.println("before sorting: ");
        for(int i: nums)
            System.out.print(i + " ");
        int[] res = object.selectionSort(nums);
        System.out.println("\nafter sorting: ");
        for(int i: res)
            System.out.print(i + " ");
    }
}
