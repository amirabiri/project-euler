package _23

import "project-euler/common/numbers"

var abundants   []int
var isAbundants []bool

func Solve() int64 {
	findAbundants()

	var sum int64
	for n := 1; n <= 28123; n++ {
		if !isAbundantSum(n) {
			sum += int64(n)
		}
	}

	return sum
}

func findAbundants() {
	abundants   = make([]int,  0, 10000)
	isAbundants = make([]bool, 28123)

	for num := 2; num <= 28123; num++ {
		if numbers.Sum(numbers.GetDivisors(num)) > num {
			abundants = append(abundants, num)
			isAbundants[num - 1] = true
		}
	}
}

func isAbundantSum(n int) bool {
	for _,abundant := range abundants {
		if (abundant >= n) {
			return false
		}
		if (isAbundants[n - abundant - 1]) {
			return true
		}
	}
	return false
}
