module euler.solutions._11;
import euler.common.solutions;
import euler.common.data;



int[][] numbers;

mixin prepare_data!(11,
{
	numbers = data_file_as_matrix!int;
});

mixin solution!(11,
{
	int max;
	
	for (int y = 0; y < 20; y++) {
		for (int x = 0; x < 17; x++) {
			foreach (dir; [[0, 1], [1, 0], [1, 1], [-1, 1]]) {
				auto yDir = dir[0];
				auto xDir = dir[1];
				
				if (yDir == -1 && y < 3)  continue;
				if (yDir == 1  && y > 16) continue;
				
				auto p = check(x, y, xDir, yDir);
				if (p > max) {
					max = p;
				}
			}
		}
	}
	
	return max;
});

int check(int x, int y, int xDir, int yDir)
{
	int product = 1;
	for (int i = 0; i < 4; i++) {
		product *= numbers[y][x];
		x += xDir;
		y += yDir;
	}
	return product;
}