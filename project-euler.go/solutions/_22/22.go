package _22

import (
	"project-euler/common/data"
	"sort"
)

var names []string

func Initialize() {
	names = data.ReadLines()
	sort.Strings(names)
}

func Solve() int64 {
	var total_sum int64 = 0
	pos := 1

	for _,name := range names {
		charSum := 0
		for i := range name {
			charSum += int(name[i]) - 64
		}
		total_sum += int64(charSum * pos)
		pos++
	}

	return total_sum
}
