module euler.solutions._4;
import euler.common.solutions;



mixin solution!(4,
{
	int  leftSide = 999;
	long num  = make_pali(leftSide);
	
	while (!check(num)) {
		leftSide--;
		num = make_pali(leftSide);
	}
	
	return num;
});

int make_pali(int num) {
	int c = num % 10;
	int b = (num / 10) % 10;
	int a = num / 100;
	
	return num * 1000 + c * 100 + b * 10 + a;
}

bool check(long num) {
	if (num % 11 != 0) return false;
	
	for (int fac = 999; fac >= 900; fac--) {
		if (num % fac == 0 && num / fac < 1000) {
			return true;
		}
	}
	
	return false;
}
