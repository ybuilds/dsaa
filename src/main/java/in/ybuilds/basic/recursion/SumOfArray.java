package in.ybuilds.basic.recursion;

import java.util.Scanner;

public class SumOfArray {
    public int arraySum(int i, int[] nums) {
        if (i >= nums.length)
            return 0;

        return nums[i] + arraySum(i+1, nums);
    }

    public int[] reverseArray(int i, int j, int[] nums) {
        if (i > j)
            return null;

        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;

        return reverseArray(i+1, j-1, nums);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SumOfArray object = new SumOfArray();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        System.out.println(object.arraySum(0, nums));
        object.reverseArray(0, n-1, nums);
        for(int i: nums)
            System.out.print(i + " ");
    }
}
