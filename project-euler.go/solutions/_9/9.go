package _9

func Solve() int64 {
	for a := 1; a <= 998 ; a++ {
		for b := a + 1; b <= 999 - a; b++ {
			c := 1000 - a - b
			if (a * a + b * b == c * c) {
				return int64(a * b *c)
			}

		}
	}

	panic("Failed to solve problem")
}
