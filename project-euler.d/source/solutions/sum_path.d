module euler.solutions.sum_path;
import euler.common.solutions;
import euler.common.data;



int solve_sum_path(int[][] triangle)
{
	auto paths = triangle.back.map!Path.array;
		
	for (long i = triangle.length - 2; i >= 0; i--) {
		Path[] next_paths;
		for (int j = 0; j < triangle[i].length; j++) {
			auto take = paths[j].sum > paths[j + 1].sum ? paths[j] : paths[j + 1];
			next_paths ~= take + triangle[i][j];
		}
		paths = next_paths;
	}
	
	return paths[0].sum;
}


struct Path
{
	public int   sum;
	public int[] path;
	
	public this(int num)
	{
		sum = num;
		path ~= num;
	}
	
	private this(int sum, int[] path)
	{
		this.sum  = sum;
		this.path = path;
	}
	
	public Path opBinary(string op)(int rhs) if (op == "+")
	{
		return Path(sum + rhs, path ~ rhs);
	}
}