package in.ybuilds.advanced.arrays;

import java.util.*;

public class IntersectionArray {
    public int[] intersectionArray(int[] nums1, int[] nums2) {
        Map<Integer, Integer> visit = new HashMap<>();
        for(int i: nums1)
            visit.put(i, visit.getOrDefault(i, 0)+1);

        List<Integer> res = new ArrayList<>();
        for(int i: nums2) {
            if (visit.getOrDefault(i, null) != null && visit.get(i) != 0) {
                res.add(i);
                visit.put(i, visit.get(i)-1);
            }
        }

        int[] resArray = new int[res.size()];
        for(int i=0; i<res.size(); i++)
            resArray[i] = res.get(i);

        return resArray;
    }

    public int[] intersectionArrayOptimal(int[] nums1, int[] nums2) {
        int i=0, j=0;
        List<Integer> res = new ArrayList<>();

        while(i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
        }

        int[] resArray = new int[res.size()];
        for(int k=0; k<res.size(); k++)
            resArray[k] = res.get(k);

        return resArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntersectionArray object = new IntersectionArray();

        int n = scanner.nextInt();
        int[] nums1 = new int[n];
        for(int i=0; i<n; i++)
            nums1[i] = scanner.nextInt();

        int m = scanner.nextInt();
        int[] nums2 = new int[m];
        for(int i=0; i<m; i++)
            nums2[i] = scanner.nextInt();

        int[] res = object.intersectionArrayOptimal(nums1, nums2);
        for(int i: res)
            System.out.print(i + " ");
    }
}
