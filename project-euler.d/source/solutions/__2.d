module euler.solutions._2;
import euler.common.solutions;



mixin solution!(2,
{
    int  a   = 1;
    int  b   = 2;
    long sum = 0;

    while (b < 4_000_000) {
        if (b % 2 == 0) {
            sum += b;
        }
        auto tmp = a + b;
        a = b;
        b = tmp;
    }
	
	return sum;
});