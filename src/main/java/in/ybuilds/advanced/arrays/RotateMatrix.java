package in.ybuilds.advanced.arrays;

import java.util.Scanner;

public class RotateMatrix {
    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        int i=0, j=n-1;
        while(i < j) {
            for(int k=0; k<n; k++) {
                int temp = matrix[k][j];
                matrix[k][j] = matrix[k][i];
                matrix[k][i] = temp;
            }
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RotateMatrix object = new RotateMatrix();

        int n = scanner.nextInt();
        int[][] mat = new int[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++)
                mat[i][j] = scanner.nextInt();
        }

        object.rotateMatrix(mat);

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }
}
