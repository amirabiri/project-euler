module euler.solutions._7;
import euler.common.solutions;
import euler.common.numbers;
import std.conv;
import std.math;



mixin solution!(7,
{
	int idx = 3;
    foreach (prime; primes) {
		idx++;
		if (idx == 10_001) {
			return prime.to!long;
		}    	
    }
});