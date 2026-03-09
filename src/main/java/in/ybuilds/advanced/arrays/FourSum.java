package in.ybuilds.advanced.arrays;

import java.util.*;

public class FourSum {
    public void backtrack(int index, int remain, int[] nums, List<Integer> curr, Set<List<Integer>> res) {
        if (remain == 0 && curr.size() == 4) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (remain < 0)
            return;

        for(int i=index; i<nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i+1, remain-nums[i], nums, curr, res);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        backtrack(0, target, nums, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FourSum object = new FourSum();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        int target = scanner.nextInt();
        System.out.println(object.fourSum(nums, target));
    }
}
