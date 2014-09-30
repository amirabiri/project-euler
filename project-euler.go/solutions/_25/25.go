package _25

import "math/big"

func Solve() int64 {
	a := big.NewInt(1)
	b := big.NewInt(1)
	ord := 2

	for {
		c := big.NewInt(0).Add(a, b)
		a = b
		b = c
		ord++
		if len(c.String()) == 1000 {
			break
		}
	}

	return int64(ord)
}
