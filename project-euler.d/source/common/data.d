module euler.common.data;

import std.stdio;
import std.string;
import std.array;
import std.algorithm;
import std.conv;
import std.path;
import std.file;


private string               base_path;
public  string               data_file;
private void function()[int] init_data_func;

void initialize_base_path(string arg0)
{
	base_path = arg0.absolutePath.dirName;
}

void register_init_data(int num, void function() func)
{
	init_data_func[num] = func;
} 

void init_solution_data(int num)
{
	void function()* func = (num in init_data_func);

	if (func !is null) {
		data_file = buildPath(base_path, num.to!string ~ ".txt");
		(*func)();
		data_file = null;
	}
}

mixin template prepare_data(int num, alias callback)
{
	static this()
	{
		register_init_data(num, callback);
	}	
}

public string[] data_file_as_lines()
{
	return data_file.slurp!(string)("%s").array;
}

public T[][] data_file_as_matrix(T)()
{
	return data_file.readText.parse_matrix!T;
}

T[][] parse_matrix(T, S)(S str) if (isSomeString!S)
{
	return str
		.strip
		.splitLines
		.map!(l => l
			.split
			.map!(to!T)
			.array)
		.array;
}