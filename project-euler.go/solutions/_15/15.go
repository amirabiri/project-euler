package _15

func Solve() int64 {
	grid := make([][]int64, 21)

	for i := 0; i < 21; i++ {
		grid[i] = make([]int64, 21)
	}

	for i := 0; i <= 20; i++ {
		grid[i][0] = 1
		grid[0][i] = 1
	}

	for i := 1; i <= 20; i++ {
		for j := 1; j <= 20; j++ {
			grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
		}
	}

	return grid[20][20]
}
