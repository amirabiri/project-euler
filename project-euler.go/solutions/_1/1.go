package _1

func Solve() int64 {
	sum := 0
	for i := 1; i < 1000; i++ {
		if (i % 3 == 0 || i % 5 == 0) {
			sum += i;
		}
	}
	return int64(sum)
}
