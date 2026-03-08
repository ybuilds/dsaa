package in.ybuilds.advanced.arrays;

import java.util.Scanner;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        for(int i=0, j=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MoveZeroes object = new MoveZeroes();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        object.moveZeroes(nums);
        for(int i: nums)
            System.out.print(i + " ");
    }
}
