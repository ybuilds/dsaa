package in.ybuilds.basic.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class SortedArray {
    public boolean isSorted(ArrayList<Integer> nums) {
        if (nums.size() == 1)
            return true;

        if (nums.get(0) > nums.get(1))
            return false;

        nums = new ArrayList<>(nums.subList(1, nums.size()));

        return isSorted(nums);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SortedArray object = new SortedArray();
        int n = scanner.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0; i<n; i++)
            nums.add(scanner.nextInt());

        System.out.println(object.isSorted(nums));
    }
}
