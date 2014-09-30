package _2

func Solve() int64 {
	a := 1
	b := 2
	var sum int64 = 0

	for b < 4000000 {
		if b % 2 == 0 {
			sum += int64(b)
		}
		tmp := a + b
		a = b
		b = tmp
	}

	return sum
}
