module euler.solutions.sum_path;
import euler.common.solutions;
import euler.common.data;



long solve_sum_path(int[][] triangle)
{
	auto paths = triangle.back;
		
	for (long i = triangle.length - 2; i >= 0; i--) {
		int[] next_paths;
		for (int j = 0; j < triangle[i].length; j++) {
			auto take = paths[j] > paths[j + 1] ? paths[j] : paths[j + 1];
			next_paths ~= take + triangle[i][j];
		}
		paths = next_paths;
	}
	
	return paths[0];
}