package in.ybuilds.basic.math;

import java.util.Scanner;

public class PerfectNumber {
    public boolean isPerfect(int n) {
        int res = 0;

        for (int i=1; i<n; i++) {
            if (n%i == 0)
                res += i;
        }

        return res == n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PerfectNumber object = new PerfectNumber();
        System.out.println();
    }
}
