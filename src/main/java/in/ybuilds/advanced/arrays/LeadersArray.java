package in.ybuilds.advanced.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LeadersArray {
    public List<Integer> leaders(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int elem = nums[i], j;
            for(j=i+1; j<nums.length; j++) {
                if (elem <= nums[j])
                    break;
            }
            if (j == nums.length)
                res.add(elem);
        }

        return res;
    }

    List<Integer> leadersOptimal(int[] nums) {
        if (nums.length == 1)
            return new ArrayList<>(List.of(nums[0]));

        List<Integer> res = new ArrayList<>();
        int n = nums.length-1;
        int max = nums[n];
        res.add(max);
        for(int i=n-1; i>=0; i--) {
            if(nums[i] > max) {
                max = nums[i];
                res.add(max);
            }
        }

        int i=0, j=res.size()-1;
        while(i <= j) {
            int temp = res.get(j);
            res.set(j, res.get(i));
            res.set(i, temp);
            i++;
            j--;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LeadersArray object = new LeadersArray();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();

        System.out.println(object.leadersOptimal(nums));
    }
}
