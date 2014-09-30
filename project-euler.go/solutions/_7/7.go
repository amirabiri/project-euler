package _7

import "project-euler/common/numbers"

func Solve() int64 {
	primes := numbers.NewPrimesGenerator()

	n := primes.Next()
	for i := 4; i < 10001; i++ {
		n = primes.Next()
	}

	return int64(n)
}
