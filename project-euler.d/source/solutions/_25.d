module euler.solutions._25;
import euler.common.solutions;
import std.math;
import std.bigint;



mixin solution!(25,
{
	BigInt a = 1, b = 1;
	ulong ord = 2;

	while (true) {
		auto c = a + b;
		a = b;
		b = c;
		ord++;
		if (c.to!string.length == 1000) {
			break;
		}
	}
	
	return ord;
});

/*
mixin solution!(25,
{
	double sqrt5 = 5.0.sqrt;
	double phi = (1.0 + sqrt5) / 2;
	
	double fibn = (phi.pow(3000) / sqrt5);	
	writeln(fibn);
	
	int n = 1000;
	while (!is_fibn_digits_1000(n)) {
		n += 1000;
	}
	return lion_in_the_desert(n - 1000, n);
});

int lion_in_the_desert(int from, int to)
{
	while (to - from > 1) {
		int half = (from + to) / 2;
		if (is_fibn_digits_1000(half)) {
			to = half;
		}
		else {
			from = half;
		}
	}
	return to;
}

bool is_fibn_digits_1000(int n)
{
	return n >= 4782;
}
*/