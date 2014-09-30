package _24

import "strconv"

var digits []int

func Solve() int64 {
	digits = []int{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }
	n   := 1000000
	fac := 362880 // factorial(9)
	ret := ""

	for i := 9; i > 0; i-- {
		ord := (n / fac)
		n %= fac
		if n == 0 {
			ord--
			n = fac
		}
		fac /= i
		digit := nthDigit(ord)
		ret += strconv.FormatInt(int64(digit), 10)
	}

	ret += strconv.FormatInt(int64(digits[0]), 10)

	retInt,_ := strconv.ParseInt(ret, 10, 64)
	return retInt
}

func nthDigit(idx int) int {
	digit := digits[idx]
	digits = append(digits[:idx], digits[idx+1:]...)
	return digit
}
