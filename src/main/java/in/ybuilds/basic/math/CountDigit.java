package in.ybuilds.basic.math;

import java.util.Scanner;

public class CountDigit {
    public int countDigit(int n) {
        if (n == 0)
            return 1;

        int count = 0;

        while (n > 0) {
            n /= 10;
            count++;
        }

        return count;
    }

    public int countOddDigit(int n) {
        if (n == 0)
            return 0;

        int count = 0;

        while (n > 0) {
            if((n%10)%2 == 1)
                count++;

            n /= 10;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CountDigit object = new CountDigit();

        System.out.println(object.countDigit(scanner.nextInt()));
    }
}
