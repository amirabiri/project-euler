package _19

import "time"

func Solve() int64 {
	sundays_first := 0
	for year := 1901; year <= 2000; year++ {
		for month := 1; month <= 12; month++ {
			t := time.Date(year, time.Month(month), 1, 0, 0, 0, 0, time.UTC)
			if t.Weekday() == time.Sunday {
				sundays_first++
			}
		}
	}
	return int64(sundays_first)
}
