module euler.solutions._25;
import euler.common.solutions;
import std.math;
import std.bigint;



mixin solution!(25,
{
	BigInt a = 1, b = 1;
	long ord = 2;

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