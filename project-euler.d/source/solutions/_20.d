module euler.solutions._20;
import euler.common.solutions;
import std.bigint;



mixin solution!(20,
{
	BigInt num = 1;

	for (int i = 2; i <= 100; i++) {
		num *= i;
	}

	return num.to!string.map!(x => x.to!int - 48).sum;
});