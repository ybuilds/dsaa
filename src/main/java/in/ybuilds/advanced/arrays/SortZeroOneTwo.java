package in.ybuilds.advanced.arrays;

import java.util.Scanner;

public class SortZeroOneTwo {
    public void sortZeroOneTwo(int[] nums) {
        int zero=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                zero++;
            }
        }

        int one=zero;
        for(int i=zero; i<nums.length; i++) {
            if(nums[i] == 1) {
                int temp = nums[one];
                nums[one] = nums[i];
                nums[i] = temp;
                one++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortZeroOneTwo object = new SortZeroOneTwo();

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();

        object.sortZeroOneTwo(nums);
        for(int i: nums)
            System.out.print(i + " ");
    }
}
