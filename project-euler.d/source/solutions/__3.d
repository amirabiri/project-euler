module euler.solutions._3;
import euler.common.solutions;



mixin solution!(3,
{
	long num = 600851475143;
	int  fac = 2;
	while (fac < num) {
		if (num % fac == 0) {
			num /= fac;
		}
		else {
			fac++;
		}
	}
	return num;
});