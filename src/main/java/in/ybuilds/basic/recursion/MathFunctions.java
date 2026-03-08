package in.ybuilds.basic.recursion;

import java.util.Scanner;

public class MathFunctions {
    public long factorial(int n) {
        if (n < 1)
            return 1;

        return n * factorial(n-1);
    }

    public int NnumbersSum(int N) {
        if (N == 0)
            return 0;

        return N + NnumbersSum(N-1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MathFunctions object = new MathFunctions();
        System.out.println(object.factorial(scanner.nextInt()));
    }
}
