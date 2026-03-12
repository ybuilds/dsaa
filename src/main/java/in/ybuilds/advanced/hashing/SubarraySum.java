package in.ybuilds.advanced.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int sum = 0;

        for(int i: nums) {
            sum += i;

            int remain = sum - k;
            if (map.containsKey(remain))
                count += map.get(remain);

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SubarraySum object = new SubarraySum();

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        int k = scanner.nextInt();

        System.out.println(object.subarraySum(nums, k));
    }
}
