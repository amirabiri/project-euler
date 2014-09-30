package _12

import "project-euler/common/numbers"

func Solve() int64 {
	number := 0
	term   := 0
	for {
		number++
		term += number
		divisors := numbers.GetDivisors(term)
		if len(divisors) > 500 {
			return int64(term)
		}
	}
}
