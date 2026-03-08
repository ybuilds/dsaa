package in.ybuilds.advanced.sorting;

import java.util.Scanner;

public class InsertionSort {
    public int[] insertionSort(int[] nums) {
        for(int i=1; i<nums.length; i++) {
            int j = i;
            while(j > 0 && nums[j-1] > nums[j]) {
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InsertionSort object = new InsertionSort();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        System.out.println("before sorting: ");
        for(int i: nums)
            System.out.print(i + " ");
        int[] res = object.insertionSort(nums);
        System.out.println("\nafter sorting: ");
        for(int i: res)
            System.out.print(i + " ");
    }
}
