package in.ybuilds.advanced.binarySearch;

import java.util.Scanner;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int low=0, high=nums.length-1, mid=0;

        while(low <= high) {
            mid = (low + high)/2;
            if (nums[mid] == target)
                return mid;
            else if (target < nums[mid])
                high = mid - 1;
            else if (target > nums[mid])
                low = mid + 1;
        }

        return  -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearch object = new BinarySearch();

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();

        int target = scanner.nextInt();

        System.out.println(object.search(nums, target));
    }
}
