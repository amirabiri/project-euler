package numbers

func Sum(arr []int) int {
	var sum int
	for _,n := range arr {
		sum += n
	}
	return sum
}

func IndexOf(arr []int, x int) int {
	for idx,n := range arr {
		if n == x {
			return idx
		}
	}
	return -1
}
