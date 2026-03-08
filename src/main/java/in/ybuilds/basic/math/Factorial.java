package in.ybuilds.basic.math;

import java.util.Scanner;

public class Factorial {
    public int factorialRecursive(int n) {
        if (n == 0)
            return 1;

        int fact = 1;
        for(int i=1; i<=n; i++)
            fact *= i;

        return fact;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Factorial object = new Factorial();
        System.out.println(object.factorialRecursive(scanner.nextInt()));
    }
}
