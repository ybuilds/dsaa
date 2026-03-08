package in.ybuilds.basic.math;

import java.util.Scanner;

public class ReverseNumber {
    public int reverseNumber(int n) {
        int res = 0;

        while (n > 0) {
            res = (res * 10) + (n % 10);
            n /= 10;
        }

        return res;
    }

    public boolean isPalindrome(int n) {
        int temp = n;
        int res = 0;

        while (temp > 0) {
            res = (res * 10) + (temp % 10);
            temp /= 10;
        }

        return n == res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReverseNumber object = new ReverseNumber();
        System.out.println(object.reverseNumber(scanner.nextInt()));
    }
}
