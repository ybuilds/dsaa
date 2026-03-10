package in.ybuilds.advanced.arrays;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MajorityElement2 {
    public List<Integer> majorityElementTwo(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Long> frequency = Arrays
                .stream(nums)
                .mapToObj(i -> (Integer)i)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

        for(Map.Entry<Integer, Long> e: frequency.entrySet()) {
            if (e.getValue() >= (nums.length / 3) + 1)
                res.add(e.getKey());
        }

        return res;
    }

    public List<Integer> majorityElement2Optimal(int[] nums) {
        List<Integer> res = new ArrayList<>();

        int c1=0, c2=0;
        int e1=Integer.MIN_VALUE, e2=Integer.MIN_VALUE;

        for (int num : nums) {
            if (c1 == 0 && num != e2) {
                c1++;
                e1 = num;
            } else if (c2 == 0 && num != e1) {
                c2++;
                e2 = num;
            } else if (e1 == num)
                c1++;
            else if (e2 == num)
                c2++;
            else {
                c1--;
                c2--;
            }
        }

        c1=0;
        c2=0;
        for(int i: nums) {
            if (i == e1)
                c1++;
            if (i == e2)
                c2++;
        }

        if (c1 >= (nums.length/3)+1)
            res.add(e1);
        if (c2 >= (nums.length/3)+1)
            res.add(e2);

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MajorityElement2 object = new MajorityElement2();
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();
        System.out.println(object.majorityElementTwo(nums));
    }
}
