package in.ybuilds.advanced.arrays;

import java.util.Scanner;

public class RearrangeSignedArray {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int positiveIndex=0, negativeIndex=1;

        for(int i: nums) {
            if (i < 0) {
                res[negativeIndex] = i;
                negativeIndex += 2;
            } else {
                res[positiveIndex] = i;
                positiveIndex += 2;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RearrangeSignedArray object = new RearrangeSignedArray();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        int[] res = object.rearrangeArray(nums);
        for(int i: res)
            System.out.print(i + " ");
    }
}
