package in.ybuilds.advanced.binarySearch;

import java.util.Scanner;

public class LowerBound {
    public int lowerBound(int[] nums, int x) {
        int low=0, high=nums.length-1, mid=0, ans=nums.length;

        while(low <= high) {
            mid = (low + high) / 2;

            if (nums[mid] >= x) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return ans;
    }

    public int upperBound(int[] nums, int x) {
        int low=0, high=nums.length-1, mid=0, ans=nums.length;

        while(low <= high) {
            mid = (low + high) / 2;

            if (nums[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LowerBound object = new LowerBound();

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();

        int x = scanner.nextInt();

        System.out.println(object.lowerBound(nums, x));
    }
}
