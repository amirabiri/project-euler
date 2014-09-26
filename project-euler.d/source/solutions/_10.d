module euler.solutions._10;
import euler.common.solutions;
import euler.common.numbers;



mixin solution!(10,
{
    long sum = 2 + 3 + 5;
    
    foreach (x; primes) {
    	if (x > 2_000_000) break;
    	sum += x;
    }

    return sum;	
});