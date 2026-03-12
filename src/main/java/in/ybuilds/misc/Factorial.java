package in.ybuilds.misc;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        if (n <= 1) {
            System.out.println(n);
            return;
        }

        int prev = 1;
        for(int i=2; i<=n; i++) {
            int curr = i * prev;
            prev = curr;
        }

        System.out.println(prev);
    }
}
