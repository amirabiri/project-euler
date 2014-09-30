package numbers

import "math"

func GetDivisors(number int) []int {
	divisors := []int{ 1 }
	sqr := int(math.Floor(math.Sqrt(float64(number))))

	for x := 2; x <= sqr; x++ {
		if number % x == 0 {
			divisors = append(divisors, x)
			opp := number / x
			if opp != x {
				divisors = append(divisors, opp)
			}
		}
	}

	return divisors
}
