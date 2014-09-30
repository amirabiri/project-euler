module euler.solutions._24;
import euler.common.solutions;
import std.range;

int[] digits;
mixin solution!(24,
{
	digits = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];
	auto n   = 1_000_000;
	auto fac = 362880; // factorial(9)
	string ret;
	
	for (int i = 9; i > 0; i--) {
		auto ord = (n / fac);
		n %= fac;
		if (n == 0) {
			ord--;
			n = fac;
		}
		fac /= i;
		auto digit = nth_digit(ord);
		ret ~= digit.to!string;
	}
	
	ret ~= digits[0].to!string;
	
	return ret.to!long;
});

int nth_digit(int idx)
{
	int digit = digits[idx];
	digits = digits[0 .. idx] ~ digits[idx + 1 .. $];
	return digit;
}