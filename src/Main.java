import sollutions.RotateMatrix;
import util.Utils;

public class Main {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {3, 4}};
        int[][] arr2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr3 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int[][] arr4 = {
                {1,  2,  3,  4,  5},
                {6,  7,  8,  9,  10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        Utils.printMatrix(arr4);
        RotateMatrix rotator = new RotateMatrix();
        rotator.rotate(arr4);
        System.out.println();
        Utils.printMatrix(arr4);
    }
}