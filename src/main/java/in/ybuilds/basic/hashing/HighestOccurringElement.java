package in.ybuilds.basic.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HighestOccurringElement {
    public int mostFrequentElement(int[] nums) {
        Map<Integer, Integer> frequency = new TreeMap<>();
        for(int i: nums)
            frequency.put(i, frequency.getOrDefault(i, 0)+1);

        int elem=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry: frequency.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                elem = entry.getKey();
            }
        }

        System.out.println(frequency);

        return elem;
    }

    public int secondMostFrequentElement(int[] nums) {
        Map<Integer, Integer> frequency = new TreeMap<>();
        for(int i: nums)
            frequency.put(i, frequency.getOrDefault(i, 0)+1);

        int max=Integer.MIN_VALUE, maxElem=-1;
        int secondMax=Integer.MIN_VALUE, elem=-1;

        for(Map.Entry<Integer, Integer> e: frequency.entrySet()) {
            if(e.getValue() > max) {
                elem = maxElem;
                maxElem = e.getKey();

                secondMax = max;
                max = e.getValue();
            } else if(e.getValue() > secondMax && e.getValue() != max) {
                secondMax = e.getValue();
                elem = e.getKey();
            }
        }

        return elem;
    }

    public int sumHighestAndLowestFrequency(int[] nums) {
        int min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;

        Map<Integer, Integer> frequency = new TreeMap<>();
        for(int i: nums)
            frequency.put(i, frequency.getOrDefault(i, 0)+1);

        for(Map.Entry<Integer, Integer> e: frequency.entrySet()) {
            if (e.getValue() > max)
                max = e.getValue();

            if (e.getValue() < min)
                min = e.getValue();
        }

        return min+max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HighestOccurringElement object = new HighestOccurringElement();
        int n = scanner.nextInt();

        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = scanner.nextInt();

        System.out.println(object.secondMostFrequentElement(nums));
    }
}
