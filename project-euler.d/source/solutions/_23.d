module euler.solutions._23;
import euler.common.solutions;
import euler.common.numbers;
import std.datetime;



mixin solution!(23,
{
	find_abundants();
	
    long sum = 0;
    for (int n = 1; n <= 28123; n++) {
        if (!is_abundant_sum(n)) {
            sum += n;
        }
    }

	return sum;
});

int[]       abundants;
bool[28123] is_abundant;

void find_abundants()
{
	abundants.destroy;
	abundants.reserve(28123);

	for (int num = 1; num <= 28123; num++) {
		auto abundant = (num.divisors.sum > num);
		if (abundant) {
			abundants ~= num;
		}
		is_abundant[num - 1] = abundant; 
	}
}

bool is_abundant_sum(int n)
{
	foreach (abundant; abundants) {
		if (abundant >= n) {
			return false;
		}
		if (is_abundant[n - abundant - 1]) {
			return true;
		}
	}
	
    return false;	
}