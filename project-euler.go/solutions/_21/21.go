package _21

import "project-euler/common/numbers"

var divisorSums []int

func Solve() int64 {
	amicables := []int{}
	divisorSums = make([]int, 10000)
	divisorSums[1] = 1

	for n := 2; n <= 10000; n++ {
		sum := sumDivisors(n)

		if sum > 10000 || sum <= n {
			continue
		}

		if sumDivisors(sum) == n {
			amicables = append(amicables, n, sum)
		}
	}

	return int64(numbers.Sum(amicables))
}

func sumDivisors(n int) int {
	sum := divisorSums[n - 1]
	if sum == 0 {
		sum = numbers.Sum(numbers.GetDivisors(n))
		divisorSums[n - 1] = sum
	}

	return sum
}
