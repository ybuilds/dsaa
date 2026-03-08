package in.ybuilds.basic.math;

import java.util.Scanner;

public class LargestDigit {
    public int largestDigit(int n) {
        if (n == 0)
            return 0;

        int max = Integer.MIN_VALUE;

        while (n >= 0) {
            if (n%10 > max)
                max = n%10;

            n /= 10;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LargestDigit object = new LargestDigit();
        System.out.println(object.largestDigit(scanner.nextInt()));
    }
}
