package in.ybuilds.advanced.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalTriangle {
    List<List<Integer>> pascal = new ArrayList<>();

    public List<List<Integer>> generate(int r) {
        for(int i=0; i<r; i++) {
            if (i == 0)
                pascal.add(new ArrayList<>(List.of(1)));
            else if (i == 1)
                pascal.add(new ArrayList<>(List.of(1, 1)));
            else {
                List<Integer> temp = new ArrayList<>(List.of(1));
                List<Integer> previous = pascal.get(i-1);
                for(int j=0; j<previous.size()-1; j++)
                    temp.add(previous.get(j) + previous.get(j+1));
                temp.add(1);
                pascal.add(temp);
            }
        }

        return pascal;
    }

    public int pascalTriangleI(int r, int c) {
        return pascal.get(r-1).get(c-1);
    }

    public int[] pascalTriangleII(int r) {
        int[] res = new int[pascal.get(r-1).size()];

        for(int i=0; i<res.length; i++)
            res[i] = pascal.get(r-1).get(i);

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PascalTriangle object = new PascalTriangle();

        int r = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(object.generate(r));

        System.out.println(object.pascalTriangleI(r, c));

        int[] pascal2 = object.pascalTriangleII(r);
        for(int i: pascal2)
            System.out.print(i + " ");
    }
}
