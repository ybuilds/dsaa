package in.ybuilds.advanced.arrays;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class UnionArray {
    public int[] unionArray(int[] nums1, int[] nums2) {
        Set<Integer> set = new TreeSet<>();

        int i=0, j=0;

        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j])
                set.add(nums1[i++]);
            else
                set.add(nums2[j++]);
        }

        while(i < nums1.length)
            set.add(nums1[i++]);

        while(j < nums2.length)
            set.add(nums2[j++]);

        int[] res = new int[set.size()];
        int k = 0;
        for(int elem: set)
            res[k++] = elem;

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UnionArray object = new UnionArray();

        int n = scanner.nextInt();
        int[] nums1 = new int[n];
        for(int i=0; i<n; i++)
            nums1[i] = scanner.nextInt();

        int m = scanner.nextInt();
        int[] nums2 = new int[m];
        for(int i=0; i<m; i++)
            nums2[i] = scanner.nextInt();

        int[] res = object.unionArray(nums1, nums2);
        for(int i: res)
            System.out.print(i + " ");
    }
}
