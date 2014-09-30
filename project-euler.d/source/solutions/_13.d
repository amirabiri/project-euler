module euler.solutions._13;
import euler.common.solutions;
import euler.common.data;
import std.bigint;



BigInt[] numbers;

mixin prepare_data!(13,
{
	numbers = data_file_as_lines.map!(line => BigInt(line)).array;	
});

mixin solution!(13,
{
	BigInt sum;
	foreach (number; numbers) {
		sum += number;
	}
	return sum.to!string[0..10].to!long;
});
