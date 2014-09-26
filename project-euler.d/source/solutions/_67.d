module euler.solutions._67;
import euler.common.solutions;
import euler.common.data;
import euler.solutions.sum_path;
import std.file;



int[][] triangle;

mixin prepare_data!(67,
{
	triangle = data_file_as_matrix!int;
});

mixin solution!(67,
{
	return solve_sum_path(triangle);	
});