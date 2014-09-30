package _26

import "project-euler/common/numbers"

func Solve() int64 {
	maxD, maxLen := 0, 0

	for d := 1; d <= 1000; d++ {
		length := unitFractionCycleLength(d)
		if length > maxLen {
			maxLen = length
			maxD   = d
		}
	}

	return int64(maxD)
}

func unitFractionCycleLength(d int) int {
	result := 1
	prev := []int{}

	for result != 0 {
		result = result * 10 % d
		idx := numbers.IndexOf(prev, result)

		if idx != -1 {
			return len(prev) - idx
		}

		prev = append(prev, result)
	}

	return 0
}
