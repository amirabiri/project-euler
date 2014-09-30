package _16

import "math/big"

func Solve() int64 {
	var twoPow1000 big.Int
	twoPow1000.Exp(big.NewInt(2), big.NewInt(1000), nil)

	twoPow1000Str := twoPow1000.String()

	var sum int64
	for i := range twoPow1000Str {
		sum += int64(twoPow1000Str[i] - 48)
	}

	return sum
}
