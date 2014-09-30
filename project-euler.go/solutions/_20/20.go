package _20

import "math/big"

func Solve() int64 {
	var num big.Int
	num.SetInt64(1)

	for i := 2; i <= 100; i++ {
		var iBig big.Int
		iBig.SetInt64(int64(i))
		num.Mul(&num, &iBig)
	}

	sum    := 0
	numStr := num.String()
	for i := range numStr {
		sum += int(numStr[i]) - 48
	}

	return int64(sum)
}
