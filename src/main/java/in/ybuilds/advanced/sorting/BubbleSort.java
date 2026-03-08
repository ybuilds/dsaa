package in.ybuilds.advanced.sorting;

import java.util.Scanner;

public class BubbleSort {
    public int[] bubbleSort(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            boolean swap = false;

            for(int j=1; j<=nums.length-i-1; j++) {
                if(nums[j-1] > nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                    swap = true;
                }
            }
            if (!swap)
                break;
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BubbleSort object = new BubbleSort();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        System.out.println("before sorting: ");
        for(int i: nums)
            System.out.print(i + " ");
        int[] res = object.bubbleSort(nums);
        System.out.println("\nafter sorting: ");
        for(int i: res)
            System.out.print(i + " ");
    }
}
