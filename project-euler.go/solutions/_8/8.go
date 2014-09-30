package _8

import "project-euler/common/data"

var digits []int

func Initialize() {
	for _,b := range data.ReadNoNewLines() {
		digits = append(digits, int(b - 48))
	}
}

func Solve() int64 {
	var max int64
	for i := 0; i < len(digits) - 12; i++ {
		var p int64 = 1
		for j := 0; j < 13; j++ {
			p *= int64(digits[i + j])
		}

		if (p > max) {
			max = p;
		}
	}

	return max;
}
