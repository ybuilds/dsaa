package in.ybuilds.advanced.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubarraySum {
    public int longestSubarray(int[] nums, int k) {
        int max=0, sum=0;

        Map<Integer, Integer> prefix = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];

            if (sum == k)
                max = i+1;

            if (prefix.containsKey(sum-k))
                max = Math.max(max, i-prefix.get(sum-k));

            if (!prefix.containsKey(sum))
                prefix.put(sum, i);
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LongestSubarraySum object = new LongestSubarraySum();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(object.longestSubarray(nums, k));
    }
}
