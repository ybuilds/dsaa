package in.ybuilds.basic.math;

import java.util.Scanner;

public class PrimeNumber {
    public boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;

        for(int i=2; i*i<=n; i++) {
            if (n%i == 0)
                return false;
        }

        return true;
    }

    public int primeUptoN(int n) {
        int count = 0;

        for(int i=0; i<=n; i++) {
            boolean isPrime = true;
            if (i == 0 || i == 1)
                continue;

            for(int j=2; j*j<=i; j++) {
                if(i%j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrimeNumber object = new PrimeNumber();
        System.out.println(object.primeUptoN(scanner.nextInt()));
    }
}
