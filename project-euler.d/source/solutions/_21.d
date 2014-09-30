module euler.solutions._21;
import euler.common.solutions;
import euler.common.numbers;



mixin solution!(21,
{
	int[] amicables;
	dsums[] = 0;

	for (int n = 2; n <= 10000; n++) {
		int sum = sum_divisors(n);

		if (sum > 10000 || sum <= n) continue;
		
		if (sum_divisors(sum) == n) {
			amicables ~= [n, sum];
		}
	}

	return amicables.sum.to!long;
});

int[10000] dsums;
int sum_divisors(int n)
{
	if (n > 1 && dsums[n - 1] == 0) {
		dsums[n - 1] = n.divisors.sum;
	}
	return dsums[n - 1];
}
