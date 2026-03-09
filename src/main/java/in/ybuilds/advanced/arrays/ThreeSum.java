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

    public List<List<Integer>> threeSumOptimal(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            int j=i+1, k=nums.length-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j-1])
                        j++;
                    while(j < k && nums[k] == nums[k+1])
                        k--;
                } else if (sum < 0)
                    j++;
                else
                    k--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThreeSum object = new ThreeSum();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        System.out.println(object.threeSumOptimal(nums));
    }
}
