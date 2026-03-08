package in.ybuilds.advanced.arrays;

import java.util.Scanner;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int xor1=0, xor2=0;

        for(int i=0; i<nums.length; i++) {
            xor1 ^= i+1;
            xor2 ^= nums[i];
        }

        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MissingNumber object = new MissingNumber();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        int pos = object.missingNumber(nums);
        System.out.println(pos);
    }
}
