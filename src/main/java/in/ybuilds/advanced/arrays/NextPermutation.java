package in.ybuilds.advanced.arrays;

import java.util.*;

public class NextPermutation {
    public void backtrack(int[] nums, int index, List<Integer> curr, List<List<Integer>> res, boolean[] visit) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                curr.add(nums[i]);

                backtrack(nums, i+1, curr, res, visit);

                visit[i] = false;
                curr.remove(curr.size()-1);
            }
        }
    }

    public void nextPermutation(int[] nums) {
        int[] keyArray = nums.clone();
        Arrays.sort(nums);
        int found = 0;
        List<Integer> next = null;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visit = new boolean[nums.length];
        backtrack(nums, 0, new ArrayList<>(), res, visit);

        for(int i=0; i<res.size(); i++) {
            List<Integer> list = res.get(i);
            int[] temp = new int[list.size()];
            for(int j=0; j<list.size(); j++)
                temp[j] = list.get(j);

            if (Arrays.equals(keyArray, temp)) {
                found = i;
                break;
            }
        }

        if (found == res.size()-1)
            next = res.get(0);
        else
            next = res.get(found);

        for(int i=0; i<nums.length; i++)
            nums[i] = next.get(i);
    }

    public void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }

    public void nextPermutationOptimal(int[] nums) {
        int n = nums.length;
        int peak = -1;
        int almostSmall = -1;
        for(int i=n-2; i>=0; i--) {
            if (nums[i] < nums[i+1]) {
                peak = i;
                break;
            }
        }

        if (peak == -1) {
            reverse(nums, 0, n-1);
            return;
        }

        for(int i=n-1; i>peak; i--) {
            if (nums[i] > nums[peak]) {
                int temp = nums[peak];
                nums[peak] = nums[i];
                nums[i] = temp;
                break;
            }
        }

        reverse(nums, peak+1, n-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NextPermutation object = new NextPermutation();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        object.nextPermutationOptimal(nums);
        for(int i: nums)
            System.out.print(i + " ");
    }
}
