package in.ybuilds.advanced.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public int[] mergeSort(int[] nums) {
        if (nums.length <= 1)
            return nums;

        int[] left = Arrays.copyOfRange(nums, 0, nums.length/2);
        int[] right = Arrays.copyOfRange(nums, nums.length/2, nums.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    public int[] merge(int[] a, int[] b) {
        int i=0, j=0, k=0;
        int[] res = new int[a.length + b.length];

        while(i < a.length && j < b.length) {
            if (a[i] <= b[j])
                res[k++] = a[i++];
            else
                res[k++] = b[j++];
        }

        while(i < a.length)
            res[k++] = a[i++];

        while(j < b.length)
            res[k++] = b[j++];

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MergeSort object = new MergeSort();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();

        System.out.println("before sorting: ");
        for(int i: nums)
            System.out.print(i + " ");
        int[] res = object.mergeSort(nums);
        System.out.println("\nafter sorting: ");
        for(int i: res)
            System.out.print(i + " ");
    }
}
