package _5

import (
	"math"
	"project-euler/common/numbers"
)

func Solve() int64 {
	superset := make(map[int]int)

	for n := 2; n <= 20; n++ {
		primeFactorsMap := reduceToMap(numbers.GetPrimeFactors(n));

		for factor, count := range primeFactorsMap {
			supersetCount := superset[factor]
			if count > supersetCount {
				superset[factor] = count
			}
		}
	}

	num := 1
	for factor, count := range superset {
		num *= int(math.Pow(float64(factor), float64(count)))
	}

	return int64(num)
}

func reduceToMap(nums []int) map[int]int {
	ret := make(map[int]int)
	for _,n := range nums {
		ret[n]++
	}
	return ret
}

