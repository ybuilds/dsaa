package in.ybuilds.basic.math;

import java.util.Scanner;

public class GcdOrHcf {
    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b%a, a);
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GcdOrHcf object = new GcdOrHcf();
        System.out.println(object.lcm(scanner.nextInt(), scanner.nextInt()));
    }
}
