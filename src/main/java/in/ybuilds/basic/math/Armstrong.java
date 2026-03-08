package in.ybuilds.basic.math;

import java.util.Scanner;

public class Armstrong {
    public boolean isArmstrong(int n) {
        int count = 0;
        int temp = n;

        while(temp > 0) {
            temp /= 10;
            count++;
        }

        int res = 0;
        temp = n;
        while(temp > 0) {
            res += (int)Math.pow(temp%10, count);
            temp /= 10;
        }

        return n == res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Armstrong object = new Armstrong();
        System.out.println(object.isArmstrong(scanner.nextInt()));
    }
}
