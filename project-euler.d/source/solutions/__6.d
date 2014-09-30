module euler.solutions._6;
import euler.common.solutions;



mixin solution!(6,
{
	long sum, sumSqrs;
	
	for (int i = 1; i <= 100; i++) {
		sum     += i;
		sumSqrs += i * i;
	}
	
	return sum * sum - sumSqrs;
});
