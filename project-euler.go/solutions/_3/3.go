package _3

func Solve() int64 {
	var num int64 = 600851475143
	var fac int64 = 2
	for fac < num {
		if num % fac == 0 {
			num /= fac
		} else {
			fac++
		}
	}
	return num
}
