package in.ybuilds.misc;

import java.util.Scanner;

public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++)
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);

        return dp[nums.length-1];
    }

    public int robOptimal(int[] nums) {
        if (nums.length == 0)
            return 0;

        if (nums.length == 1)
            return nums[0];

        int p2 = 0;
        int p1 = 0;

        for(int i: nums) {
            int curr = Math.max(p1, p2+i);
            p2 = p1;
            p1 = curr;
        }

        return p1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HouseRobber object = new HouseRobber();

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();

        System.out.println(object.robOptimal(nums));
    }
}
