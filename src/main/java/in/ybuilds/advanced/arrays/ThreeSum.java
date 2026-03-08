package in.ybuilds.advanced.arrays;

import java.util.*;

public class ThreeSum {
    public void backtrack(int index, int[] nums, List<Integer> curr, Set<List<Integer>> res) {
        if (curr.size() == 3) {
            int sum = 0;
            for(int i: curr)
                sum += i;

            if (sum == 0)
                res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=index; i<nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i+1, nums, curr, res);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        backtrack(0, nums, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThreeSum object = new ThreeSum();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        System.out.println(object.threeSum(nums));
    }
}
