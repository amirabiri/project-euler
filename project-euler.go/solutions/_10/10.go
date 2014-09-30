package _10

import "project-euler/common/numbers"

func Solve() int64 {
	var sum int64 = 2 + 3 + 5

	primes := numbers.NewPrimesGenerator()
	x := primes.Next()
	for ; x < 2000000; x = primes.Next() {
		sum += int64(x)
	}

	return sum
}
