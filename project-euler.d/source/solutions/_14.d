module euler.solutions._14;
import euler.common.solutions;
import std.range;



int[] term_length_cache;

mixin solution!(14,
{
	term_length_cache = [];
	term_length_cache.length = 1_000_000;
	
	int  longest;
	long term;
	
	foreach (n ; iota(1, 1_000_000)) {
		auto length = term_length(n);
		if (length > longest) {
			longest = length;
			term = n;
		}
	}
	
	return term;
});

int term_length(long number)
{
	if (term_length_cache[number - 1] == 0) {
		find_term_length(number);
	}
	
	return term_length_cache[number - 1];
}

void find_term_length(long number) {
	long[] path;
	
	while (number != 1 && (number > 1_000_000 || term_length_cache[number - 1] == 0)) {
		path ~= number;
		number = next_term(number);
	}
	
	if (number == 1) {
		set_cache(path, 1);
	}
	else {
		set_cache(path, term_length_cache[number - 1]);
	}
}

long next_term(long n) {
	if (n % 2 == 0) {
		return n / 2;
	}
	else {
		return 3 * n + 1;
	}
}

void set_cache(long[] path, int start) {
	for (int i = 0; i < path.length; i++) {
		if (path[i] <= 1_000_000) {
			term_length_cache[path[i] - 1] = cast(int)path.length - i + start;
		}
	}
}