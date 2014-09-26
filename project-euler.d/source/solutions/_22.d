module euler.solutions._22;
import euler.common.solutions;
import euler.common.data;
import std.file;



string[] names;

mixin prepare_data!(22,
{
	names = data_file_as_lines;
	sort(names);
});

mixin solution!(22,
{
	long total_sum;
	int pos = 1;

	foreach (name; names) {
		total_sum += name.map!(c => c - 64).sum * pos++;
	}
	
	return total_sum;
});