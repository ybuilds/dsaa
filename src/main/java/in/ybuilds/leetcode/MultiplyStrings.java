package in.ybuilds.leetcode;

import java.util.Scanner;

public class MultiplyStrings {
    public String add(String s1, String s2, int n) {
        StringBuilder res = new StringBuilder();
        s1 = s1 + "0".repeat(Math.max(0, n));

        int i=s1.length()-1, j=s2.length()-1, carry=0;
        while(i >= 0 && j >= 0) {
            int digit1 = s1.charAt(i) - '0';
            int digit2 = s2.charAt(j) - '0';

            int sum = carry + digit1 + digit2;
            carry = sum / 10;
            res.append(sum%10);

            i--;
            j--;
        }

        while(i >= 0) {
            int digit = s1.charAt(i) - '0';
            int sum = carry + digit;
            carry = sum / 10;
            res.append(sum%10);
            i--;
        }

        while(j >= 0) {
            int digit = s2.charAt(j) - '0';
            int sum = carry + digit;
            carry = sum / 10;
            res.append(sum%10);
            j--;
        }

        if (carry > 0)
            res.append(carry);

        return res.reverse().toString();
    }

    public String multiply(String s1, String s2) {
        if (s1.equals("0") || s2.equals("0"))
            return "0";

        String res = "0";

        int n = s2.length();
        int m = s1.length();

        for(int i=n-1; i>=0; i--) {
            StringBuilder temp = new StringBuilder();
            int digit1 = s2.charAt(i) - '0';
            int carry = 0;
            for(int j=m-1; j>=0; j--) {
                int digit2 = s1.charAt(j) - '0';
                int product = carry + (digit1 * digit2);
                temp.append(product % 10);
                carry = product / 10;
            }
            if (carry > 0)
                temp.append(carry);
            temp.reverse();
            res = add(temp.toString(), res, n-1-i);
        }

        return res;
    }

    public String factorial(int n) {
        if (n < 1)
            return "1";
        return multiply(String.valueOf(n), factorial(n-1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MultiplyStrings object = new MultiplyStrings();

        int n = scanner.nextInt();

        System.out.println("Factorial of " + n + " = " + object.factorial(n));
    }
}
