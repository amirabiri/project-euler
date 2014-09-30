package _14

var termLengthCache []int

func Solve() int64 {
	termLengthCache = make([]int, 1000000)

	longest := 0
	term    := 0

	for n := 1; n <= 1000000; n++ {
		length := termLength(n)
		if length > longest {
			longest = length
			term    = n
		}
	}

	return int64(term)
}

func termLength(number int) int {
	if termLengthCache[number - 1] == 0 {
		findTermLength(number)
	}

	return termLengthCache[number - 1]
}

func findTermLength(number int) {
	path := []int{}

	for (number != 1) && (number > 1000000 || termLengthCache[number - 1] == 0) {
		path = append(path, number)
		number = nextTerm(number)
	}

	if (number == 1) {
		setCache(path, 1)
	} else {
		setCache(path, termLengthCache[number - 1])
	}
}

func nextTerm(n int) int {
	if (n % 2 == 0) {
		return n / 2
	} else {
		return 3 * n + 1
	}
}

func setCache(path []int, start int) {
	for i,number := range path {
		if number <= 1000000 {
			termLengthCache[number - 1] = len(path) - i + start
		}
	}
}
