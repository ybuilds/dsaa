package in.ybuilds.basic.recursion;

import java.util.Scanner;

public class SumOfDigits {
    public int addDigits(int num) {
        if (num >= 0 && num < 10)
            return num;

        return addDigits(sum(num));
    }

    public int sum(int n) {
        if (n == 0)
            return 0;

        return (n%10) + sum(n/10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SumOfDigits object = new SumOfDigits();
        System.out.println(object.addDigits(scanner.nextInt()));
    }
}
