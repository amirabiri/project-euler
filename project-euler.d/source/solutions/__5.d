module euler.solutions._5;
import euler.common.solutions;
import euler.common.numbers;
import std.range;



mixin solution!(5,
{
	int[int] superset;
	
	foreach (n; iota(2, 21)) {
		foreach (factor, count; n.prime_factors.reduce_to_map) {
			int supersetCount = superset.get(factor, 0);
			if (count > supersetCount) {
				superset[factor] = count;
			}
		}
	}
	
	int num = 1;
	foreach (factor, count; superset) {
		for (int i = 0; i < count; i++) {
			num *= factor;
		}		
	}
		
	return num;
});

int[int] reduce_to_map(int[] numbers)
{
	int[int] ret;
	foreach (n; numbers) {
		ret[n] = ret.get(n, 0) + 1;
	}
	return ret;
}