module euler.solutions._9;
import euler.common.solutions;
import std.range;



mixin solution!(9,
{
    foreach (a; iota(1, 999)) {
    	foreach (b; iota(a + 1, 1000 - a)) {
    		auto c = 1000 - a - b;
            if (a * a + b * b == c * c) {
                return a * b *c;
            }
    	}
    }
	
	throw new Exception("Failed to solve problem");
});