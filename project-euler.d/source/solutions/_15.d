module euler.solutions._15;
import euler.common.solutions;



mixin solution!(15,
{
    long[21][21] grid;

    for (int i = 0; i <= 20; i++) {
        grid[i][0] = 1;
        grid[0][i] = 1;
    }

    for (int i = 1; i <= 20; i++) {
        for (int j = 1; j <= 20; j++) {
            grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
        }
    }

    return grid[20][20];
});
