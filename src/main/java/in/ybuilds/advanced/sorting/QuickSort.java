package in.ybuilds.advanced.sorting;

import java.util.Scanner;

public class QuickSort {
    public int[] quickSort(int[] nums) {
        return sort(0, nums.length-1, nums);
    }

    public int[] sort(int low, int high, int[] nums) {
        if (low < high) {
            int partition = partition(low, high, nums);
            sort(low, partition-1, nums);
            sort(partition+1, high, nums);
        }

        return nums;
    }

    public int partition(int low, int high, int[] nums) {
        int pivot = nums[low];
        int i=low, j=high;

        while(i < j) {
            while(nums[i] <= pivot && i < high)
                i++;
            while(nums[j] > pivot && j > low)
                j--;

            if(i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        int temp = nums[j];
        nums[j] = nums[low];
        nums[low] = temp;

        return j;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuickSort object = new QuickSort();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        System.out.println("before sorting: ");
        for(int i: nums)
            System.out.print(i + " ");
        int[] res = object.quickSort(nums);
        System.out.println("\nafter sorting: ");
        for(int i: res)
            System.out.print(i + " ");
    }
}
