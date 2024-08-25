package sollutions;

import java.util.Objects;

@SuppressWarnings("unused")
public class RotateMatrix {
    private void rotate(String[][] matrix) {
        if (Objects.isNull(matrix))
            return;
        int l = matrix.length, x = l / 2, y = l - 1;
        if (l < 2)
            return;
        for (int i = 0; i < x; i ++)
            for (int j = i; j < y - i; j ++) {
                String temp = matrix[i][j];
                matrix[i][j] = matrix[y - j][i];
                matrix[y - j][i] = matrix[y - i][y - j];
                matrix[y - i][y - j] = matrix[j][y - i];
                matrix[j][y - i] = temp;
            }
    }
}
