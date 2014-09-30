module euler.solutions._26;
import euler.common.solutions;
import std.range;



mixin solution!(26,
{
	long maxD;
	int  maxLen;
	
	foreach (d; iota(1, 1000)) {
		auto length = unit_fraction_cycle_length(d);
		if (length > maxLen) {
			maxLen = length;
			maxD = d;
		}
	}
	
	return maxD;
});

int unit_fraction_cycle_length(int d)
{
	int result = 1;
	int[] prev;

	while (result != 0)
	{
		result = result * 10 % d;
		auto idx = prev.countUntil(result);

		if (idx != -1) {
			return (prev.length - idx).to!int;
		}

		prev ~= result;
	}

	return 0;
}