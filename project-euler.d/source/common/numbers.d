module euler.common.numbers;
import std.conv;
import std.math;
import std.range;

T[] divisors(T)(T n)
{
	T[] ret = [1];
	auto sqr = n.to!real.sqrt.lrint;

	for (T x = 2; x <= sqr; x++) {
		if (n % x == 0) {
			ret ~= x;
			auto opp = n / x;
			if (opp != x) {
				ret ~= opp;
			}
		}
	}

	return ret;
}

int[] P30 = [1, 7, 11, 13, 17, 19, 23, 29];

struct ProbablePrimesRange
{
	private int i = 1;
	private int k = 0;
	private int x = 7;
	
    enum empty = false;

    @property int front() const
    {
        return x;
    }

    void popFront()
    {
		i++;
		if (i == P30.length) {
			k++;
			i = 0;
		}
		x = k * 30 + P30[i];
    }	
}

ProbablePrimesRange probablePrimes()
{
	ProbablePrimesRange ret;
	return ret;
}

struct PrimesRange
{
	private int[]               primes = [2, 3, 5, 7];
	private ProbablePrimesRange probablePrimes;
	
    enum empty = false;

    @property int front() const
    {
        return probablePrimes.front;
    }

    void popFront()
    {
		probablePrimes.popFront();
    	while (!isPrime(front)) {
    		probablePrimes.popFront();
    	}
    	primes ~= front;
    }
    
    private bool isPrime(int number)
    {
    	auto sqr = number.to!real.sqrt.lrint;
		foreach (p; primes) {
			if (p > sqr)         break;
			if (number % p == 0) return false;
		}
    	return true;
    }
}

PrimesRange primes()
{
	PrimesRange ret;
	return ret;
}

bool is_prime(int n)
{
	if (n < 2)
		return false;
	
	if (n < 6) {
		return n != 4;
	}
	
	if (n % 2 == 0 || n % 3 == 0 || n % 5 == 0)
		return false;
	
	auto sqr = n.to!real.sqrt.lrint;
	
	foreach (x; probablePrimes) {
		if (x > sqr)    break;
		if (n % x == 0) return false;
	}
	
	return true;
}

int[] prime_factors(int n)
{
	int[] factors;
	
	foreach (i; [ 2, 3, 5 ]) {
		while (n % i == 0) {
			factors ~= i;
			n /= i;
		}		
	}
	
	foreach (x; probablePrimes) {
		if (x > n / x) break;
		while (n % x == 0) {
			factors ~= x;
			n /= x;
		}
	}
	
	if (n > 1) {
		factors ~= n;
	}
	
	return factors;
}

int factorial(int n)
{
	int f = 1;
	for (int i = 1; i <= n; i++) {
		f *= i;
	}
	return f;
}