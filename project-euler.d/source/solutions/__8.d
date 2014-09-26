module euler.solutions._8;
import euler.common.solutions;
import euler.common.data;



int[] digits;

mixin prepare_data!(8,
{
	digits = data_file_as_lines.join("").map!(chr => chr.to!int - 48).array;
});

mixin solution!(8,
{
	long max;
	for (int i = 0; i < digits.length - 12; i++) {
		long p = 1;
		foreach (digit; digits[i..i+13]) {
			p *= digit;
		}
		
		if (p > max) {
			max = p;
		}
	}
	
	return max;
});