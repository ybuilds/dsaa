package in.ybuilds.advanced.arrays;

import java.util.*;

public class FourSum {
    public void backtrack(int index, int sum, int target, int[] nums, List<Integer> curr, Set<List<Integer>> res) {
        if (curr.size() == 4 && sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (index > nums.length)
            return;

        for(int i=index; i<nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i+1, sum+nums[i], target, nums, curr, res);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();
        backtrack(0, 0, target, nums, new ArrayList<>(), set);
        return new ArrayList<>(set);
    }

    public List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            for(int j=i+1; j<nums.length; j++) {
                if (j > i+1 && nums[j] == nums[j-1])
                    continue;

                int k=j+1, l=nums.length-1;
                while(k < l) {
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        res.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while(k < l && nums[k] == nums[k-1])
                            k++;
                        while(k < l && nums[l] == nums[l+1])
                            l--;
                    }
                    else if (sum < target)
                        k++;
                    else
                        l--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FourSum object = new FourSum();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        int target = scanner.nextInt();
        System.out.println(object.fourSumOptimal(nums, target));
    }
}
