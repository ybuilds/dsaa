package in.ybuilds.advanced.arrays;

import java.util.Scanner;

public class KadaneAlgorithm {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE, curr=0;
        int start=-1, end=-1;

        for(int i: nums) {
            curr += i;

            if (curr == 0)
                start = i;

            if (curr > max) {
                max = curr;
                end = i;
            }

            if (curr < 0)
                curr = 0;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KadaneAlgorithm object = new KadaneAlgorithm();

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        System.out.println(object.maxSubArray(nums));

    }
}
