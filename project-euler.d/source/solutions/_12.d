module euler.solutions._12;
import euler.common.solutions;
import euler.common.numbers;



mixin solution!(12,
{
	int  number = 0;
	long term   = 0;
	while (true) {
		number++;
		term += number;
		if (term.divisors.length > 500) {
			return term;
		}
	}
});
