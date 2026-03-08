package in.ybuilds.advanced.arrays;

import java.util.Scanner;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int len = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] != nums[len]) {
                len++;
                nums[len] = nums[i];
            }
        }

        return len+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RemoveDuplicates object = new RemoveDuplicates();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        int pos = object.removeDuplicates(nums);
        System.out.println(pos);
    }
}
