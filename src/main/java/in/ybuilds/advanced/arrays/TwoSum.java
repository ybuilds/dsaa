package in.ybuilds.advanced.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> contain = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            int remain = target - num;

            if(contain.containsKey(remain))
                return new int[] {i, contain.get(remain)};

            contain.put(num, i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TwoSum object = new TwoSum();

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        int target = scanner.nextInt();

        int[] res = object.twoSum(nums, target);
        for(int i: res)
            System.out.print(i + " ");
    }
}
