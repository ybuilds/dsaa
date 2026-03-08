package in.ybuilds.basic.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Divisors {
    public int[] divisors(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            if (n%i == 0)
                res.add(i);
        }

        int[] arr = new int[res.size()];
        for(int i=0; i<arr.length; i++)
            arr[i] = res.get(i);

        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Divisors object = new Divisors();
        int[] res = object.divisors(scanner.nextInt());
        for(int i: res)
            System.out.print(i + " ");
    }
}
