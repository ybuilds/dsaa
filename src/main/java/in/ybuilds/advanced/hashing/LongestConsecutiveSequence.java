package in.ybuilds.advanced.hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int max = Integer.MIN_VALUE, curr = 0;
        Arrays.sort(nums);

        for(int i=0; i<nums.length-1; i++) {
            if(nums[i] == nums[i+1]) {
                continue;
            }
            if (nums[i] < nums[i+1] && nums[i]+1 == nums[i+1]) {
                curr++;
                max = Math.max(max, curr);
            } else {
                curr = 0;
            }
        }

        return max == Integer.MIN_VALUE ? 1 : max+1;
    }

    public int longestConsecutiveOptimal(int[] nums) {
        if(nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        for(int i: nums)
            set.add(i);

        int max=Integer.MIN_VALUE, count=0;
        for(int i: nums) {
            if (!set.contains(i-1)) {
                count = 0;
                int x = i;
                while(set.contains(x++))
                    count++;
            }

            max = Math.max(max, count);
        }

        return max;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LongestConsecutiveSequence object = new LongestConsecutiveSequence();

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        System.out.println(object.longestConsecutive(nums));
    }
}
