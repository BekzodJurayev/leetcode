package sollutions;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int r = 0, l1 = grid.length, l2 = grid[0].length;
        for (int i = 0; i < l1; i ++)
            for (int j = 0; j < l2; j ++)
                if (grid[i][j] == 1) {
                    r += i == 0 || grid[i - 1][j] == 0 ? 1 : 0;
                    r += j == l2 - 1 || grid[i][j + 1] == 0 ? 1 : 0;
                    r += i == l1 - 1 || grid[i + 1][j] == 0 ? 1 : 0;
                    r += j == 0 || grid[i][j - 1] == 0 ? 1 : 0;
                }
        return r;
    }
}
