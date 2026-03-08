package in.ybuilds.basic.recursion;

import java.util.Scanner;

public class PrimeNumber {
    public boolean checkPrime(int i, int num) {
        if (i*i > num)
            return true;

        if (num%i == 0)
            return false;

        return checkPrime(i+1, num);
    }

    public boolean checkPrimeIterative(int num) {
        if (num == 0 || num == 1)
            return false;

        for(int i=2; i*i<=num; i++) {
            if (num%i == 0)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrimeNumber object = new PrimeNumber();
        int n = scanner.nextInt();
        System.out.println(object.checkPrime(2, n));
    }
}
