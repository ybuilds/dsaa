package in.ybuilds.advanced.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int top=0, left=0, right=matrix[0].length-1, bottom=matrix.length-1;

        while(top <= bottom && left <= right) {
            for(int i=left; i<=right; i++)
                res.add(matrix[top][i]);
            top++;

            for(int i=top; i<=bottom; i++)
                res.add(matrix[i][right]);
            right--;

            if (top <= bottom) {
                for(int i=right; i>=left; i--)
                    res.add(matrix[bottom][i]);
                bottom--;
            }

            if (left <= right) {
                for(int i=bottom; i>=top; i--)
                    res.add(matrix[i][left]);
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SpiralMatrix object = new SpiralMatrix();
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] mat = new int[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++)
                mat[i][j] = scanner.nextInt();
        }

        System.out.println(object.spiralOrder(mat));
    }
}
